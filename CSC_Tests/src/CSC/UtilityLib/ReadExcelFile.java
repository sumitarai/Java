/* This class lib will read from Excel spreadsheet using Apache POI.
 *  Work book, sheet and Cell column remains same for the method and can be access from any class
 *   
 *    References:
 *    https://stackoverflow.com/questions/30125465/cannot-get-a-text-value-from-a-numeric-cell-poi/30125586
 *    http://essentialsoftwaretesting.blogspot.in/2017/10/how-to-read-excel-file-in-selenium.html
 *    
 *    
 * @author Sumita Rai
 * April 25, 2018
 * Last Mod: 5/10/2018  
 */

package UtilityLib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
	XSSFWorkbook wb;
	XSSFSheet sheetTab;
	
	public ReadExcelFile(String excelPath){   // create a constructor
		
		try {
			File testSrcFile = new File(excelPath);
			FileInputStream fis = new FileInputStream(testSrcFile);
			wb = new XSSFWorkbook(fis);					// class is coming from apache poi for xlsx workbook
			
		} catch (Exception e) {
			System.out.println("ReadExcelFile: Error encountered " + e.getMessage());
		}
	}
	
	public String getNameInfo(int sheetNum, int row,int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String custLN = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return custLN;			
	}
	
	public String getStreetInfo(int sheetNum, int row, int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String custAdd = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return custAdd;	
	}
	
	public String getPostalInfo(int sheetNum, int row, int col) {
		sheetTab = wb.getSheetAt(sheetNum);
		DataFormatter formatter = new DataFormatter(); 			 // Change to formatter because of error:Cannot get a STRING value from a NUMERIC cell
		String postalAdd = formatter.formatCellValue(sheetTab.getRow(row).getCell(col));      
		return postalAdd;	
	}
	
	public String getBatch(int sheetNum, int row, int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String batchNum = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return batchNum;
	}
	
	public String getCloser(int sheetNum, int row, int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String closer = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return closer;	
	}
	
	public String getGreeter(int sheetNum, int row, int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String greeter = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return greeter;
	}
	
	
	
}


