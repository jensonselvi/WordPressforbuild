package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorgpressLoginPage {
	WebDriver driver;

	// TODO Auto-generated constructor stub
	By username = By.id("user_login");
	By password = By.id("user_pass");
	By loginButton = By.xpath("//input[@id='wp-submit']");
	By checkname = By.id("rememberme");

	public WorgpressLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUserNameandPassword(String userid, String pass) {
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);

	}

	public void clickonloginbutton() {
		driver.findElement(loginButton).click();
	}

}
