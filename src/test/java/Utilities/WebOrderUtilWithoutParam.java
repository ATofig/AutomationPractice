package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;


public class WebOrderUtilWithoutParam {
	
	/*
	 * Navigate to WebOrder App
	 */
	
	public static void openWebOrderApp() {
		
		Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		
	}
	
	/*
	 * Login with fixed username password
	 */
	
	public static void login() {
		
		Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
		
	}
	
	/*
	 * Login with fixed username password
	 * @param username
	 * @param password
	 */
	public static void login(String username, String password) {
		
		Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
		Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
		Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
		
	}
	
	/*
	 * Logging out from WebOrder App
	 */
	public static void logout() {
		
		Driver.getDriver().findElement(By.id("ctl00_logout")).click();
		
	}

	
	/*
	 * check if we are at all order page
	 * @return true if at all order page false if not
	 */
	
	public static boolean isAtAllOrderPage() {

	
	
		
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
		
		try {
		//	wait.until(urlToBe("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx"));
			wait.until(visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']")));
			result = true;
		}catch(TimeoutException e){
			System.out.println("Not at Order Page" + e.getMessage());		

		}
		
		return result;
	}


    public static void selectSideBarTab(String tabName) {
		
		Driver.getDriver().findElement(By.linkText(tabName)).click();
		
	}
 
    
    /**
     * check all checkboxes by clicking check all button 
     * @return true if all checked false if not
     */

    public static boolean checkAll() {
    	
    	Driver.getDriver().findElement(By.linkText("Check All")).click();
    	
    	List<WebElement> allChecks = Driver.getDriver().findElements(By.cssSelector("input[id$='OrderSelector'][type='checkbox']"));
    	
    	boolean result = true;
    	// as long as one of them are not checked , return false immediately 
    	
    	for(WebElement eachCheck : allChecks) {
    		
    		if( ! eachCheck.isSelected()) {
    			result = false;
    		}
    	}
    	
    	return result;
    }

    
    /**
     * uncheck all checkboxes by clicking check all button 
     * @return true if all unchecked ,false if not
     */
    public static boolean unCheckAll() {
    	
    	Driver.getDriver().findElement(By.linkText("Uncheck All")).click();
    	
    	List<WebElement> allChecks = Driver.getDriver().findElements(By.cssSelector("input[id$='OrderSelector'][type='checkbox']"));
    	
    	boolean result = true;
    	// as long as one of them are not checked , return false immediately 
    	
    	for(WebElement eachCheck : allChecks) {
    		
    		if( eachCheck.isSelected()) {
    			result = false;
    		}
    	}
    	
    	return result;
    }

  /**
   * Check for login error message after invalid login
   * @return return true if it shows up in 1 second , false if not
   */
    public static boolean loginErrorMessageVisible() {
		
		String errorMsgXpath ="//span[text()='Invalid Login or Password.']";
		
		return BrowserUtil.checkVisibilityOfElement(By.xpath(errorMsgXpath),1);
    	
    	
    }
}
