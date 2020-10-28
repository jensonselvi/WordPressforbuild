package com.wordpress.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenUsingDataProvider {
	WebDriver driver;

	@Test(dataProvider = "wordpress")
	public void logintowordpress(String username, String password) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jenso\\eclipse-workspace\\com.wordpress\\src\\test\\resources\\binaries\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Assert.assertEquals("http://demosite.center/wordpress/wp-admin/", driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
		System.out.println("User is able to log in");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "wordpress")

	public Object[][] passData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin1";
		data[0][1] = "demo1";

		data[1][0] = "admin";
		data[1][1] = "demo123";

		data[2][0] = "admin2";
		data[2][1] = "demo1234";

		return data;

	}

}
