package com.wordpress.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	Properties pro;

	public ExcelDataConfig(String excelpath) {

		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheet1 = wb.getSheetAt(0);
			pro = new Properties();
			pro.load(fis);

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public String getActualURL() {
		return pro.getProperty("ActualURL");
	}

	public String getExcelfile() {
		String path1 = pro.getProperty("ExcelDataFile");
		return path1;
	}

	public String getData(int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetindex) {
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row = row + 1;
		return row;

	}
}
