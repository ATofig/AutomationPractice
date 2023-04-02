package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Singleton pattern
 * 1. Make constructor private
 * 2. private static field
 * 3. public getter for the field
 *    - if the static field is not assigned value yet (is null)
 *    	create new object and assign to it
 *    - if not return same static field value
 * 
 * 
 */

public class Driver {
	
	
	private static WebDriver obj;
	
	
	private Driver(){ }
	
	public static WebDriver getDriver() {
		
		
		
		if(obj == null) {
			
			String browserName = ConfigurationReader.getProperty("browser");
			
			switch (browserName.toLowerCase())  {
			
			case "chrome" :
				
				WebDriverManager.chromedriver().setup();
				obj = new ChromeDriver();
				break;
		
			case "edge" :
				
				WebDriverManager.edgedriver().setup();
				obj = new EdgeDriver();
				break;
				
			case "firefox" :
				
				WebDriverManager.firefoxdriver().setup();
				obj = new FirefoxDriver();
				break;
				
			default :
				
					System.out.println("UNKNOW BROWSER TYPE " + browserName);
					obj = null;
			
			}
			
			obj.manage().window().maximize();
			
			return obj; 
		
		}
		
		return obj;
	}
	
	
	public static void closeBrowser() {
	
		if(obj != null) {
			
			obj.quit();
			obj = null;
			
		}
	}


}
