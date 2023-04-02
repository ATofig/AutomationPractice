package com.cybertek;

import static org.testng.Assert.*;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import Utilities.TestBase;
import Utilities.WebDriverFactory;



public class PracticeCyberTechTasks extends TestBase {
	

	
	@Test
	public void forgetPassword() {
		
		driver.get("http://practice.cybertekschool.com/forgot_password");
		
		driver.findElement(By.name("email")).sendKeys("test@mail.ru" + Keys.ENTER);
		
		String confirnmationLink = driver.getCurrentUrl();
		
		assertTrue(confirnmationLink.endsWith("email_sent"));
		
		
	}
	
	@Test
	public void javasciptAlerts() throws InterruptedException {
		
		driver.get("http://practice.cybertekschool.com/javascript_alerts");
		
		// alert JS Alert
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		Alert alertObj = driver.switchTo().alert();
		
		assertEquals("I am a JS Alert",alertObj.getText());
		
		alertObj.accept();
		
		// alert JS Confirm accept
		
	    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		 alertObj = driver.switchTo().alert();
		
		assertEquals("I am a JS Confirm",alertObj.getText());
		
		alertObj.accept();
		
		
		// alert JS Confirm dismiss
		
	    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		 alertObj = driver.switchTo().alert();
		
		assertEquals("I am a JS Confirm",alertObj.getText());
		
		alertObj.dismiss();
		
		
		// alert JS Prompt
		
	// alert JS Confirm accept
		
	    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		 alertObj = driver.switchTo().alert();
		
		assertEquals("I am a JS prompt",alertObj.getText());
		
		alertObj.sendKeys("Hello");
		alertObj.accept();
	
	}
	
	
	@Test
	public void sortableGetDataTable() {
		
		driver.get("http://practice.cybertekschool.com/tables");
		
		String cell3Locator = "//table[@id='table2']/tbody/tr[3]/td";
		
		List <WebElement> cell3 = driver.findElements(By.xpath(cell3Locator));
		
		for(WebElement each : cell3) {
			
			System.out.println(each.getText());
				
		}
		
	}
	
	@Test
	public void iframe() {
		
		driver.get("http://practice.cybertekschool.com/iframe");
		
		// switch iframe by index
		//driver.switchTo().frame(0);
		
		//switch iframe by WebElement
		
		WebElement iframeEle = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(iframeEle); 
		
	
		// switch with ID or Name
		//	driver.switchTo().frame(("mce_0_ifr"));
		
		String content = "Your content goes here.";
		
		WebElement actualContent = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
		
		assertEquals(content,actualContent.getText());
	}
	
	@Test
	public void iframeNested() {
		
		driver.get("http://practice.cybertekschool.com/nested_frames");
		
		// go to bottom iframe assert content
		driver.switchTo().frame("frame-bottom");
		
		WebElement bottomIframeElem = driver.findElement(By.tagName("body"));
		String bottomIframeTextActual  = bottomIframeElem.getText();
		String bottomIframeTextExpected  = "BOTTOM";
		
		assertEquals(bottomIframeTextExpected,bottomIframeTextActual);
		
		// go to top left iframe assert content
		
		driver.switchTo().defaultContent();
		
        driver.switchTo().frame("frame-top");
		
        driver.switchTo().frame("frame-left");
	

		
		WebElement topLeftIframe = driver.findElement(By.tagName("body"));
		

		String topLeftTextActual  = topLeftIframe.getText();
		String topLeftTextExpected  = "LEFT";
		
		assertEquals(topLeftTextExpected,topLeftTextActual);


		// go to top middle iframe assert content
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-middle");
		
		WebElement topMiddletIframe = driver.findElement(By.tagName("body"));
		

		String topMiddleTextActual  = topMiddletIframe.getText();
		String topMiddleTextExpected  = "MIDDLE";
		
		assertEquals(topMiddleTextExpected,topMiddleTextActual);
		
		
	// go to top right iframe assert content
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-right");
		
		WebElement topRighttIframe = driver.findElement(By.tagName("body"));
		

		String topRightTextActual  = topRighttIframe.getText();
		String topRightTextExpected  = "RIGHT";
		
		assertEquals(topRightTextExpected,topRightTextActual);
}
	
	
	
	@Test
	public void dynamicControls1() {
		
		driver.get("http://practice.cybertekschool.com/dynamic_controls");
		
		// click on remove button
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		
		//Identify It's gone!
		WebElement itsGoneText = driver.findElement(By.id("message"));
		
		assertEquals("It's gone!",itsGoneText.getText());
		
	}
	
	@Test
	public void dynamicControls2() throws InterruptedException {
		
	
		
		
	}
	
	
	@Test
	public void fileupload() throws InterruptedException {
		
		driver.get("http://practice.cybertekschool.com/upload");
		
		String filePath = "C:\\Users\\tofig\\OneDrive\\Desktop";
		driver.findElement(By.xpath("//*[@name='file']")).sendKeys(filePath)	;
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@Test
	public void testPerformHoverAction() {
		
		driver.get("http://practice.cybertekschool.com/hovers");
					
		// assert 1st image
		WebElement firstImg = driver.findElement(By.xpath("//div[@class='figure'][1]"));
		WebElement firstImgText = driver.findElement(By.xpath("//h5[text()='name: user1']"));
		
		assertFalse(firstImgText.isDisplayed());
		
		Actions actions = new Actions(driver);
		 actions.moveToElement(firstImg).perform();
		assertTrue(firstImgText.isDisplayed());
		
		
		// assert 2st image
		
		WebElement scndImg = driver.findElement(By.xpath("//div[@class='figure'][2]"));
		WebElement scndImgText = driver.findElement(By.xpath("//h5[text()='name: user2']"));
		
		assertFalse(scndImgText.isDisplayed());
		
		actions.moveToElement(scndImg).perform();
		
		assertTrue(scndImgText.isDisplayed());
		
		// assert 3 st image
		
		WebElement thrdImg = driver.findElement(By.xpath("//div[@class='figure'][3]"));
		WebElement thrdImgText = driver.findElement(By.xpath("//h5[text()='name: user3']"));
		
		assertFalse(thrdImgText.isDisplayed());
		
		actions.moveToElement(thrdImg).perform();
		
		assertTrue(thrdImgText.isDisplayed());
		
	}
	

	@Test
	public void testDragAndDrop()  {
		
		driver.get("http://practice.cybertekschool.com/drag_and_drop_circles");
		
	WebElement smallCircle = driver.findElement(By.id("draggable"));
	WebElement bigCircle = driver.findElement(By.id("droptarget"));
	Actions actions = new Actions(driver);
	
	// with dragAndDrop Method
//	actions.dragAndDrop(smallCircle, bigCircle).perform();
	
	// drag and drop manually
	
	actions.moveToElement(smallCircle).pause(1000)
			.clickAndHold().pause(1000)
			.moveToElement(bigCircle).pause(1000)
			.release()
			.perform();
	
	String confirmText = driver.findElement(By.xpath("//div[text()='You did great!']")).getText();
	String expectedText = "You did great!";
	
	assertEquals(expectedText,confirmText);

	
	
		
	}
	
	@Test
	public void actionsPractice() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		
		Actions action = new Actions(driver);
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		action.moveToElement(searchBox).pause(2000)
			.keyDown(Keys.SHIFT).sendKeys("type with holding shift ")
			.keyUp(Keys.SHIFT).sendKeys("type without shift").pause(2000)
			.keyDown(Keys.CONTROL).sendKeys("a").pause(2000)
			.sendKeys(Keys.BACK_SPACE)
			.perform();
		
		Thread.sleep(3000);
	
	}
	
	@Test
	public void rightClickPractice() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[.='right click me']"));
		
		Actions action = new Actions(driver);
		action.contextClick(rightClickBtn).perform();
		
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		
		String actualAlertText = driver.switchTo().alert().getText();
		String expectedAlerText = "clicked: copy";
		assertEquals(expectedAlerText,actualAlertText);
		driver.switchTo().alert().accept();

	
	}
	
	
	@Test
	public void doubleClickPractice() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
		
		Actions action = new Actions(driver);
		
		action.doubleClick(doubleClickBtn).perform();
		
		String actualAlertText = driver.switchTo().alert().getText();
		String expectedAlerText = "You double clicked me.. Thank You..";
		driver.switchTo().alert().accept();
		
		assertEquals(expectedAlerText,actualAlertText);
		
		
		Thread.sleep(3000);
	
	}
	
	@Test
	public void jsExecuterPractice1() throws InterruptedException {
		
		driver.get("http://practice.cybertekschool.com/large");
		
		WebElement schoolLnk = driver.findElement(By.linkText("CYDEO"));
		WebElement homeLnk = driver.findElement(By.linkText("Home"));
		
		JavascriptExecutor jsO = (JavascriptExecutor) driver;
		
		jsO.executeScript("arguments[0].scrollIntoView(true)", schoolLnk);
		
		assertTrue(schoolLnk.isDisplayed());
		Thread.sleep(3000);
		
		
		jsO.executeScript("arguments[0].scrollIntoView(true)", homeLnk);
		
		assertTrue(homeLnk.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	public void jsExecuterPractice2() throws InterruptedException {
		
		driver.get("http://practice.cybertekschool.com/infinite_scroll");
		
		JavascriptExecutor jsO = (JavascriptExecutor) driver;
	
		Thread.sleep(2000);
		jsO.executeScript("window.scrollBy(0,5000)");	
		Thread.sleep(2000);
		jsO.executeScript("window.scrollBy(0,-5000)");	
		Thread.sleep(2000);
		
		for(int i = 0; i < 5; i++) {
			
			jsO.executeScript("window.scrollBy(0,750)");	
			Thread.sleep(1000);
			
		}  

	}
	
	@Test
	public void explicitWaitExample7() {
		
		driver.get("http://practice.cybertekschool.com/dynamic_loading");
		driver.findElement(By.partialLinkText("Example 7")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		wait.until(ExpectedConditions.titleIs("Dynamic title"));
		
		WebElement successMsg = driver.findElement(By.id("alert"));
		assertTrue(successMsg.isDisplayed());
		
	}
		
}
