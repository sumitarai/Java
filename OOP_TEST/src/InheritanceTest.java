
//import java.sql.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;  
import java.util.Date; 



/*
 * This class shows how the getter and setter encapsulate the private variable and allow inheritance of super class
 * Subclass can access the empNum and empSal properties from super class Employee
 * 
 */


public class InheritanceTest {
	
	
	public static void main(String[] args) {
		
		
			//Super class setter and getter
			Employee employee = new Employee();
			employee.setEmpNum(10);
			employee.setEmpSal(1000);
			employee.employeeName("Sumi");
			employee.emotion();   
			
			
			System.out.println("Employee Number: " + employee.getEmpNum());
			System.out.println("Employee Name: " + employee.name);
			System.out.println("Employee Salary: "+ employee.getEmpSal());
		
			System.out.println("Employee: "+ employee.getEmpNum() + " name is : " + employee.name +" and earns " + employee.getEmpSal() +" biweekly" );
			
		
			// Sub class setter and getter  
			EmployeeWithTerritory empTerritory = new EmployeeWithTerritory(); //instantiate an object
			empTerritory.setEmpTeritory(500);
			empTerritory.setEmpNum(22);
			empTerritory.setEmpSal(10000);
			empTerritory.salRange();
			
			System.out.println("Employee Territory: "+ empTerritory.getEmpTeritory());
			System.out.println("Employee Number: " + empTerritory.getEmpNum());
			System.out.println("employee Salary: "+ empTerritory.getEmpSal());
		
			System.out.println("Territory "+ empTerritory.getEmpTeritory() + ","+ "Employee: "+ empTerritory.getEmpNum() +" earns $"+ empTerritory.getEmpSal());			
			
			
			writeLog("Employee "+ employee.getEmpNum() + " name is " + employee.name +" and earns " + employee.getEmpSal() +" biweekly" );
			
			writeLog("Employee Territory: "+ empTerritory.getEmpTeritory());
			writeLog("Employee Number: " + empTerritory.getEmpNum());
			 
			
						
			
			}	
		public static void writeLog(String strLog){
		Logger logger = Logger.getLogger("EmployeeTestLog");   // logger class provides methods for logging process
		
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
			Date date = new Date();  			  
			String currentDateTime = formatter.format(date);
			
			// This block configure the logger with handler and formatter
			FileHandler fh = new FileHandler("C:/Work/Automation/TestLog/EmployeeTestLogFile"+ currentDateTime+".log");
			logger.addHandler(fh);
			logger.info(strLog);
			}catch (Exception e){
				System.out.println("Error encountered: " + e.getMessage());
			}		
		}

}
