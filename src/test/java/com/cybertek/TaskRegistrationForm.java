package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Utilities.TestBase;
import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskRegistrationForm extends TestBase {
	


	
	@Test
	public void registrationTask() throws InterruptedException {
		
		driver.get("http://practice.cybertekschool.com/registration_form");
		
		WebElement pageHeader = driver.findElement(By.xpath("//div[@class='page-header']/h2"));
		
		Assert.assertEquals("Registration form",pageHeader.getText());
		
		
		WebElement firstName = driver.findElement(By.xpath("//div[@class='col-sm-5']/input[@placeholder='first name']"));
		firstName.sendKeys("Amir");
		
		WebElement lastName = driver.findElement(By.xpath("//div[@class='col-sm-5']/input[@placeholder='last name']"));
		lastName.sendKeys("Teymur");

		WebElement usertName = driver.findElement(By.xpath("//div[@class='form-group has-feedback']//input[@name='username']"));
		usertName.sendKeys("AmirTeymur");

		WebElement emailBox = driver.findElement(By.xpath("//div[@class='form-group has-feedback']//input[@name='email']"));
		emailBox.sendKeys("amirteymur@gmail.com");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("AmirTeymur123456");

		WebElement phoneNumber = driver.findElement(By.xpath("//div[@class='form-group has-feedback']//input[@name='phone']"));
		phoneNumber.sendKeys("445-545-1225");

		driver.findElement(By.xpath("//input[@value='male']")).click();
		
		WebElement date = driver.findElement(By.xpath("//input[@name='birthday']"));
		date.sendKeys("01/01/2001");

		driver.findElement(By.xpath("//select[@name='department']")).click();
		driver.findElement(By.xpath("//option[@value='TRO']")).click();
		
		driver.findElement(By.xpath("//select[@name='job_title']")).click();
		driver.findElement(By.xpath("//option[text()='SDET']")).click();
		driver.findElement(By.xpath(" //input[@id='inlineCheckbox2']")).click();
		
		driver.findElement(By.xpath(" //*[@id='wooden_spoon']")).click();
		
		Thread.sleep(2000);
		
		String expectedSuccessMessg = "You've successfully completed registration!";
		String actualSuccessMessg = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		
		Assert.assertEquals(expectedSuccessMessg,actualSuccessMessg);

		
	}
	
	
	@Test
	public void sauceLabTest() throws InterruptedException {
		
	
		driver.get("https://www.saucedemo.com/");
		
		WebElement usertName = driver.findElement(By.xpath("//*[@id='user-name']"));
		usertName.sendKeys("standard_user");


		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).submit();
	}
	

}
