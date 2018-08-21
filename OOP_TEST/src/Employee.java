

/*
 * Getter and setter methods encapsulate the fields of a class by making them accessible only through its public methods and keep the value themselves private.
 * getter(aka accessor) which returns the value of the private member variables.
 * mark instance variable private and provide public setter and getter for access control
 */

public class Employee {
		
	    public String name; // this instance variable is visible for any child class
	    
		private int empNum;
		
		private double empSal;  // salary variable is visible in Employee class only

		
// The name variable is assigned a value
				public void employeeName(String empName) {
					name = empName;			
				}
				
				
// getter method return the private variable
				public int getEmpNum(){
					return empNum;
				}		
				
				public double getEmpSal(){
					return empSal;
				}
		
 //setter method set the value and assign to the private variable				
		public void setEmpNum(int empNumber){
		empNum = empNumber;	
		}
		
		// The Salary variable is assigned a value
		public void setEmpSal(double empSalary){
		empSal = empSalary;
		}


		public void emotion() {
			
				if (empSal > 5000) {
					System.out.println(name + " is very happy.");
					}
				else if (empSal > 2500){
					System.out.println(name + " is OK.");
				}
				else {
					System.out.println(name +" is not happy.");
				}
			
			
		}
		

}


