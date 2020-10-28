package com.wordpress.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wordpress.pages.WorgpressLoginPage;
import com.wordpress.util.BrowserFactory;
import com.wordpress.util.ConfigReader;

public class Wordpressvalidlogin {
	WebDriver driver;
	ConfigReader objectrepository = new ConfigReader();

	@Test
	public void checkValidlogin() {

		BrowserFactory browserfactory = new BrowserFactory();

		driver = browserfactory.startBrowser("chrome", objectrepository.getApplicationURL());

		WorgpressLoginPage loginpage = new WorgpressLoginPage(driver);
		loginpage.typeUserNameandPassword("admin", "demo123");
		loginpage.clickonloginbutton();

		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(objectrepository.getActualURL(), currenturl);
		Reporter.log("Success login", true);

	}
}