package com.cybertek;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import Utilities.BrowserUtil;
import Utilities.Driver;
import Utilities.TestBase;
import Utilities.WebOrderUtil;
import Utilities.WebOrderUtilWithoutParam;

public class WebOrderTest extends TestBase {
	
	
	@Test
	public void testLogin() {
		
	//	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		WebOrderUtil.openWebOrderApp(driver);
//		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		WebOrderUtil.login(driver);
		
		WebOrderUtil.logout(driver);
		
		WebOrderUtil.login(driver,"Tester","test");
		
		WebOrderUtil.logout(driver);
		
		BrowserUtil.waitFor(3);
		
		
	
		
	}
	
	@Test
	public void testLoginWithInvalidCredentials() {
		
		WebOrderUtilWithoutParam.openWebOrderApp();
		
		WebOrderUtilWithoutParam.login("wrong", "credentials");
		
		assertEquals("Web Orders Login",Driver.getDriver().getTitle());
		
		assertTrue(	WebOrderUtilWithoutParam.loginErrorMessageVisible() );
	}
	
	@Test
	public void testUrlExist() {
		
		WebOrderUtilWithoutParam.openWebOrderApp();
		
		WebOrderUtilWithoutParam.login();
		
		assertTrue(WebOrderUtilWithoutParam.isAtAllOrderPage());
		
		
	}
	
	@Test
	public void testSideBar() {
		
		WebOrderUtilWithoutParam.openWebOrderApp();
		
		WebOrderUtilWithoutParam.login();
		
		BrowserUtil.waitFor(2);
		WebOrderUtilWithoutParam.selectSideBarTab("View all orders");

		BrowserUtil.waitFor(2);
		WebOrderUtilWithoutParam.selectSideBarTab("View all products");

		BrowserUtil.waitFor(2);
		WebOrderUtilWithoutParam.selectSideBarTab("Order");
	
	}
	
	@Test
	public void checkAll() {
		
		WebOrderUtilWithoutParam.openWebOrderApp();
		
		WebOrderUtilWithoutParam.login();
		
		assertTrue(WebOrderUtilWithoutParam.checkAll());
		
		assertTrue(WebOrderUtilWithoutParam.unCheckAll());
		
		
	}

}
