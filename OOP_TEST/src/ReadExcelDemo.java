

import lib.ExcelDataConfig;

public class ReadExcelDemo {

	public static void main(String[] args) {
		ExcelDataConfig excelData = new ExcelDataConfig("C:\\Work\\Java\\OOP_TEST\\Resource\\TestDataExample.xlsx");
		System.out.println(excelData.getData(0, 0, 0));
	}

}
