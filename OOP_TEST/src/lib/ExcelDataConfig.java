package lib;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheetTab;
	
	
	public ExcelDataConfig(String excelPath){  // Create constructor
	
	try {
		File testSrcFile = new File(excelPath);
		FileInputStream fis;
		fis = new FileInputStream(testSrcFile);
		wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
		System.out.println("Error encountered : " + e.getMessage());
		
		}	
	}
	
	public String getData(int sheetNum, int row, int col){
		sheetTab = wb.getSheetAt(sheetNum);
		String data = sheetTab.getRow(row).getCell(col).getStringCellValue();
		return data;
	}


}


