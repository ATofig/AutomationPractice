package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
static WebDriver driver;
	
	public static WebDriver get(String browserName) {
		
		switch (browserName.toLowerCase())  {
			
		case "chrome" :
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox" :
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge" :
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "opera" :
			
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
			
		case "safari" :
			
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
			
		default :
			
				System.out.println("UNKNOW BROWSER TYPE " + browserName);
				driver = null;
	
		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		return driver;
		
	}

}
