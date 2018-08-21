import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	public static void main(String[] args) throws IOException  {
		
		File testSrc = new File("C:\\Work\\Java\\OOP_TEST\\Resource\\TestDataExample.xlsx");  // path of the excel file
		FileInputStream fis = new FileInputStream(testSrc);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);  		// class is coming from apache poi for xlsx workbook
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data1 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from Excel: " + data1);
		
		
		int rowCount = sheet1.getLastRowNum();
		System.out.println("Total row : " +rowCount);
		
		for (int i = 1; i <= rowCount; i++) {				// This will read from row 2
			String data2 = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Data from Excel: " + data2);
			
		}
		
		
		
		
		
	wb.close();	  //close XSSFWorkbook resource otherwise there will be a memory leak

	}

}
