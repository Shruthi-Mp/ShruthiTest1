package com.shoppingApp.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/main/resources/CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(file);
		String value = pobj.getProperty(key);
		return value;
	}
	public String fetchDatafromExcel(String sheetname,int rownum,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("./src/main/resources/TestData2.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cel = row.getCell(cellno);
		String value = cel.getStringCellValue();
		return value;	
	}
	public void setDatainExcel(String sheetname,int rownum,int cellno,String value) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/main/resources/TestData2.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.createSheet(sheetname);
		Row ro = sh.createRow(rownum);
		Cell cel = ro.createCell(cellno);
		cel.setCellValue(value);
		FileOutputStream fout = new FileOutputStream("./src/main/resources/TestData2.xlsx");
		book.write(fout);
	}
}
