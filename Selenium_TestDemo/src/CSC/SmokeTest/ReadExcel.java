/* This class allow to read from the spreadsheet using jxl.
 *  Work book, sheet and Cell column remains same for the method and can be access from any class
 *   
 * Ref: http://www.vogella.com/tutorials/JavaExcel/article.html#installation
 * 
 * @author Sumita Rai
 * December 26, 2017
 * Last Mod: 04/25/2018  
 * 
 */
package SmokeTest;

import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
	private String inputFile;
    File inputWorkbook;
    
    public void setInputFile(String inFile) {
    	inputFile = inFile;
    	//System.out.println(inputFile);
    	inputWorkbook = new File(inputFile);
    	}
    
 
 // Method to get Name info from the SetupExcel sheet to create a new customer
    public String getNameInfo(int nameRow){
		
		String strCustName;
		Workbook custName;
		try {
			custName = Workbook.getWorkbook(inputWorkbook);
			Sheet Sheet = custName.getSheet(5);
			Cell Cell = Sheet.getCell(1,nameRow);
			strCustName = Cell.getContents();
			return strCustName;
					
		}catch (Exception e) {
			System.out.println("ReadExcel.getNameInfo - Error encounterd: " + e.getMessage());
			return null;	
		}
    }		
 // Method to get Street Address info from the Excel sheet to create a new customer
    public String getStreetInfo(int streetRow){
			
			String strStreetAdd;
			Workbook streetAdd;
			try {
				streetAdd = Workbook.getWorkbook(inputWorkbook);
				Sheet Sheet = streetAdd.getSheet(5);
				Cell Cell = Sheet.getCell(2,streetRow);
				strStreetAdd = Cell.getContents();
				return strStreetAdd;
						
			}catch (Exception e) {
				System.out.println("ReadExcel.getStreetInfo -Error encounterd: " + e.getMessage());
				return null;	
			}
	}	    
// Method to get postal info from the Excel sheet to create a new customer
   public String getPostalInfo(int postalRow){
			
			String strPostalAdd;
			Workbook postalAdd;
			try {
				postalAdd = Workbook.getWorkbook(inputWorkbook);
				Sheet Sheet = postalAdd.getSheet(5);
				Cell Cell = Sheet.getCell(3,postalRow);
				strPostalAdd = Cell.getContents();
				return strPostalAdd;
						
			}catch (Exception e) {
				System.out.println("ReadExcel.getPostalInfo - Error encounterd: " + e.getMessage());
				return null;	
			}
	}    
   
   
 
    
 // Method to read Batches Excel sheet
    public String getBatch(int batchNum){
    		String strBatch;
    		Workbook batch;
    		try {
    			batch = Workbook.getWorkbook(inputWorkbook);
    			Sheet  sheet = batch.getSheet(1);
    			Cell cell = sheet.getCell(1,batchNum);
    			strBatch = cell.getContents();
    			return strBatch;
    			}catch (Exception e){
    				System.out.println("ReadExcel.getBatch - Error encounterd: " + e.getMessage());
    				return null;
    			}    	
    	}     
 // Method to get Item Price from the Batch Excel sheet
    public double getItmPrice(int priceNum){
    		String strPrice;
    		Workbook price;
    		try {
    			price = Workbook.getWorkbook(inputWorkbook);
    			Sheet Sheet = price.getSheet(2);
    			Cell Cell = Sheet.getCell(3,priceNum);  //This will pull price from forth column
    			strPrice = Cell.getContents();		// get item price	
    			return Double.parseDouble(strPrice);			
    		}catch (Exception e) {
    				System.out.println("ReadExcel.getItmPrice - Error encounterd: " + e.getMessage());
    				return 0.00;
    		}
    	}      
 // Method to get Tax rate from the Batch Excel sheet
    public double getTaxRate(){
    	String strTaxRate;
    	Workbook taxRate;
    	try{
    		taxRate = Workbook.getWorkbook(inputWorkbook);
    		Sheet sheet = taxRate.getSheet(2);
    		Cell cell = sheet.getCell(7,0);  // This pull Tax rate from H column and 2nd row
    		strTaxRate = cell.getContents();
    		return Double.parseDouble(strTaxRate);
    	}catch(Exception e){
    		System.out.println("ReadExcel.getTaxRate - Error encounterd: " + e.getMessage());
    		return 0.00;
    	}
    	
    }
    
    
    
 // Method to get Closer info from the Batch Excel sheet
    public String getCloserInfo(int closerNum){
		String strCloser;		
		File inputWorkbook = new File(inputFile);
		Workbook closer;
		try {
			closer = Workbook.getWorkbook(inputWorkbook); 
			Sheet Sheet = closer.getSheet(1);
			Cell Cell = Sheet.getCell(0,closerNum);  // Read from column 0
			strCloser = Cell.getContents();	
			return strCloser;	
			
		}catch (Exception e) {
			System.out.println("ReadExcel.getCloserInfo - Error encounterd: " + e.getMessage());
			return null;	
		}
	}
    
 // Method to get Greeter info from the Excel sheet to feed greeter info 
    public String getGreetInfo(int greeterNum){		
		String strGreeter;
		Workbook closer;
		try {
			closer = Workbook.getWorkbook(inputWorkbook);
			Sheet Sheet = closer.getSheet(1);
			Cell Cell = Sheet.getCell(1,greeterNum);
			strGreeter = Cell.getContents();
			return strGreeter;
					
		}catch (Exception e) {
			System.out.println("ReadExcel.getGreeterInfo - Error encounterd: " + e.getMessage());
			return null;	
		}
    }  
}
