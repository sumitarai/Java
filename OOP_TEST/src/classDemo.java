/* http://essentialsoftwaretesting.blogspot.in/2017/08/basic-guide-for-class-objects-and.html
 * This class shows static and non-static methods
 * Class is an entity that binds data members and methods in a single unit. It creates an object which defines its state and behavior
 * State is a data type and behavior is a method
 */
public class classDemo {
	
	//Variables (State) 
	int x = 10;		//initialize data members
	int y= 20;
	
	public static void main(String[] args) {
	 System.out.println("Start Program..");
	 classDemo obj1= new classDemo();				//* Instantiate an object of the class to call method and state
	 obj1.sum();									// non-static method sum() is called through an object using dot operator
	 System.out.println("Value of x "+ obj1.x);		// obj1 can be reused to access variables
	 System.out.println("Value of y " + obj1.y);
	 
	 
	 //Access non-static methods and variables from another class Calculator by creating an object and using dot (.) operator
	 Calculator obj2= new Calculator();
	 obj2.add();
	 obj2.sub();
	 System.out.println("Non-static Example: My name is " + obj2.name + " and my hobby is to "+ obj2.hobby);
	 
	 
	 //Access static methods and variable from another class AdvCalculator directly using class name and dot (.) operator. We don't have to create an object
	 AdvCalculator.add();
	 AdvCalculator.sub();
	 System.out.println("Static example: My name is " + AdvCalculator.name + " and my hobby is to "+ AdvCalculator.hobby);
	 
	 
	 
	 System.out.println("End program");
		
	}
	
	
	// Non- static method example
	public void sum(){
		int a=30;
		int b=40;
		int c= a +b;
		
		System.out.println("Sum of a and b is "+ c);
		
	}

}
