package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceLabUtilities {
	
	
	public static void navigateToSauceLab() {
		
		Driver.getDriver().get("https://www.saucedemo.com/");
	}
	
	
public static void loginSauceLab() {
		
	Driver.getDriver().findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	
	Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	
	Driver.getDriver().findElement(By.xpath("//input[@id='login-button']")).click();
	
	}

}
