package com.wordpress.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigReader {
	Properties pro;
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ConfigReader() {
		// TODO Auto-generated constructor stub
		try {
			File src = new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}

	}

	public String getchromepath() {
		String path = pro.getProperty("chromeDriver");
		return path;
	}
	public String getedgepath() {
		return pro.getProperty("EdgeDriver");
	}

	public String getApplicationURL() {
		return pro.getProperty("URL");
	}

	public String getActualURL() {
		return pro.getProperty("ActualURL");
	}

	public String getExcelfile() {
		String path1 = pro.getProperty("ExcelDataFile");
		return path1;
	}

}
