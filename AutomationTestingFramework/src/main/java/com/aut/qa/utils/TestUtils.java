package com.aut.qa.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {
    
	public static int Implicite_wait=20;
	public static int Page_Load_Timeout=30;
	
	
	public static String Test_Data_Sheet = "C:\\Users\\Dell\\OneDrive\\Documents\\TestData-dataDriven.xlsx";
    public static String Sheet_name = "Customer_Info";
    
    public static Workbook workbook;
    public static Sheet sheet;
    
    
    public static Object[][] GetTestData(String sheetName) throws Exception {
    	
    	FileInputStream FIS = new FileInputStream(Test_Data_Sheet);
    	workbook = WorkbookFactory.create(FIS);
    	sheet = workbook.getSheet(sheetName);
    	
    	Object [] [] data = new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
    	
    	System.out.println("the last row number is" + sheet.getLastRowNum());
    	System.out.println("the last cell number is "+ sheet.getRow(0).getLastCellNum());

    	for(int i = 0 ; i <sheet.getLastRowNum(); i++) {
    		
    		for (int j = 0 ; j<sheet.getRow(0).getLastCellNum();j++) {
    			
    			data[i][j]= sheet.getRow(i+1).getCell(j).toString();
    			
    			System.out.println(data[i][j]);
    			
    		}
    	}
    	
    	return data;
    	
    }










}
