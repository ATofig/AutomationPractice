package Utilities;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class BrowserUtil {
	
	/*
	 * Waiting for x second without handling exception
	 *  @param  second 
	 * 
	 */
	
	public static void waitFor( int second) {
		
		
		try {
			Thread.sleep(second *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * Check for the visibility of element
	 * @param locator
	 * @param timeToWait
	 * @return 
	 * @return
	 */
	
	
		public static boolean checkVisibilityOfElement(By locator,int timeToWait) {
		
			boolean result = false;
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWait);
			
			try {
			//	wait.until(urlToBe("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx"));
				wait.until(visibilityOfElementLocated(locator));
				result = true;
			}catch(TimeoutException e){
				System.out.println("Not at Order Page" + e.getMessage());		

			}
			
			return result;
		
	}

}
