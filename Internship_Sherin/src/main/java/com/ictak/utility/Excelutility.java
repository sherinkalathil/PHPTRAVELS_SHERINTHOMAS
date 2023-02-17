package com.ictak.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	public static XSSFSheet excelWsheet;
	public static XSSFWorkbook excelWBook;
	public static String getCellData(String sheetName,int RowNum,int ColNum) throws IOException
	{
		FileInputStream ExcelFile=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources"+"/testData.xlsx");
		excelWBook=new XSSFWorkbook(ExcelFile);
		excelWsheet=excelWBook.getSheet(sheetName);
		return excelWsheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	}


}
