package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setBrowser() {
		
		driver = Driver.getDriver(); //WebDriverFactory.get("chrome");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		
	}
	
	@AfterMethod
	public void cleanUp() {
		
		//driver.close();
		//driver.quit();
		Driver.closeBrowser();
	}
}
