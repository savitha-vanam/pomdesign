package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private  static Workbook book;
	private static Sheet sheet;
	private static String TEST_SHEET_DATA_PATH="./src/main/java/com/qa/hubspot/testdata/hubspot.xlsx";
	public static Object[][] getTestData(String sheetname) {
		Object data[][]=null;
		try {
			FileInputStream ip=new FileInputStream(TEST_SHEET_DATA_PATH);
			 book=WorkbookFactory.create(ip);
			 sheet= book.getSheet(sheetname);
			 
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			 
			 for(int i=0;i<sheet.getLastRowNum();i++) {
				 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j]= sheet.getRow(1+i).getCell(j).toString();
					 
				 }
				 
			 }
			 
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
}
