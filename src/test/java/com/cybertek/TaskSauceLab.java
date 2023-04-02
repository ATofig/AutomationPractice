package com.cybertek;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Utilities.BrowserUtil;
import Utilities.Driver;
import Utilities.SauceLabUtilities;
import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskSauceLab extends TestBase {
	
	
	@Test
	public void assertTitle() {
		SauceLabUtilities.navigateToSauceLab();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		
		assertEquals(expectedTitle,actualTitle);
		
		
	}
	
	@Test
	public void loginToSauceLab() throws InterruptedException {

		SauceLabUtilities.navigateToSauceLab();
		
		SauceLabUtilities.loginSauceLab();
		
		BrowserUtil.waitFor(2);
		
		String actualHeader = driver.findElement(By.xpath("//div[@id='header_container']//span")).getText();
		System.out.println(actualHeader);
		String expectedHeader = "Products";
		assertEquals(expectedHeader,actualHeader);
	}
	
	@Test
	public void verifyPrices() {
		
		SauceLabUtilities.navigateToSauceLab();
	
		SauceLabUtilities.loginSauceLab();

		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		for (WebElement onePrices : allPrices) {
			
			System.out.println(onePrices.getText());
		}
		
		
		
	}
	
	@Test
	public void addToCart() {
		
		SauceLabUtilities.navigateToSauceLab();

		SauceLabUtilities.loginSauceLab();

		WebElement addItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		addItem.click();
		
		
		
		WebElement toCartBtn = driver.findElement(By.xpath("//a/span[@class='shopping_cart_badge']"));
		toCartBtn.click();
		
		
		String actualHeader = driver.findElement(By.xpath("//span[text()='Your Cart']")).getText();
		String expectedHeader = "Your Cart";
		
		assertEquals(expectedHeader,actualHeader);
		
		
		
		
		WebElement checkoutBTN = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkoutBTN.click();
				
	}
	
	@Test
	public void checkoutPage() throws InterruptedException {
		

		SauceLabUtilities.navigateToSauceLab();
		
		SauceLabUtilities.loginSauceLab();
		

		WebElement addItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		addItem.click();
		
		
		
		WebElement toCartBtn = driver.findElement(By.xpath("//a/span[@class='shopping_cart_badge']"));
		toCartBtn.click();
		
	
		WebElement checkoutBTN = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkoutBTN.click();
		
		
		String actualHeader = driver.findElement(By.xpath("//span[text()='Checkout: Your Information']")).getText();
		String expectedHeader = "Checkout: Your Information";
		
		assertEquals(expectedHeader,actualHeader);		
		
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
		firstName.sendKeys("Tofig");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
		lastName.sendKeys("Amir");
		
		WebElement zipCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
		zipCode.sendKeys("10000");
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.submit();
		
		
		
		String actualCheckoutHeader = driver.findElement(By.xpath("//span[text()='Checkout: Overview']")).getText();
		String expecteCheckoutdHeader = "Checkout: Overview";
		Thread.sleep(2000);
		
		assertEquals(expecteCheckoutdHeader,actualCheckoutHeader);	

		WebElement finishBtn = driver.findElement(By.xpath("//button[@id='finish']"));
		finishBtn.click();
		
		String actualCompliteHeader = driver.findElement(By.xpath("//span[text()='Checkout: Complete!']")).getText();
		String expectedComplitedHeader = "Checkout: Complete!";

		assertEquals(expectedComplitedHeader,actualCompliteHeader);	

	}
	

	

}
