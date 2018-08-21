package testcode;

public class Calculator {
			
		public int add(int a, int b){
			System.out.println("Calculator.add - It performs addition");
			return a + b;			
		}
		
		public String addString(String firstName , String lastName){
			return firstName + " " + lastName;
		}	
		
		
		public int sub(int c, int d){
			System.out.println("Calculator.sub - It performs substraction");
			return c - d;
		}
		
		public int[] getArray() {
			int[] arrayEx = {1,2,3};
			return arrayEx;			
		}
		

	

}
