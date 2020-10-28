package com.wordpress.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	ConfigReader objrep = new ConfigReader();

	public WebDriver driver;

	public WebDriver startBrowser(String browsername, String url) {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", objrep.getchromepath());

			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", objrep.getedgepath());

			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}