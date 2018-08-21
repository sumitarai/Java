/*
 * This is a child class of Employee class. 
 * It inherits the properties (fields and methods) of superclass by instantiating an object of subclass.
 */
public class EmployeeWithTerritory extends Employee {
	
	Employee employee = new Employee();
	
	private int empTeritory;
	
	public int getEmpTeritory(){
		return empTeritory;
	}
	
	public void setEmpTeritory(int teritory){
		empTeritory = teritory;
	}
	 public EmployeeWithTerritory() {
		// TODO Auto-generated constructor stub
	}
	 
	 public void salRange(){
		 
		 if(empTeritory > 400){
			 System.out.println(name + " will get 5000 salary");
		 }else{
			 System.out.println(name + " will get less than 5000 salary");
		 }
	 }
		
	
}
