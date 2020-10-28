package com.wordpress.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.util.ConfigReader;
import com.wordpress.util.ExcelDataConfig;

public class TestSeleniumChrome {
	ConfigReader config = new ConfigReader();
	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", config.getchromepath());
		System.out.println("set up is ready");
	}

	@Test(dataProvider = "wordpress")
	public void logintowordpress(String username, String password) {
		driver = new ChromeDriver();
		System.out.println("Navigation to URL");
		driver.get(config.getApplicationURL());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

		Assert.assertEquals(config.getActualURL(), driver.getCurrentUrl());

		System.out.println("User is able to log in");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "wordpress")

	public Object[][] passData() {

		ExcelDataConfig configExcel = new ExcelDataConfig(config.getExcelfile());

		int noofrows = configExcel.getRowCount(0);
		Object[][] data = new Object[noofrows][2];
		for (int i = 0; i < noofrows; i++) {

			data[i][0] = configExcel.getData(0, i, 0);
			data[i][1] = configExcel.getData(0, i, 1);

		}

		return data;

	}
}
