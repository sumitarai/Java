/* 04/06/2018
 * This class will show polymorphism which means one thing in multiple form. Method name are same but arguments are different.
 * Method overloading: Different parameter within class and compile time polymorphism. Compile time/ Early binding
 * Method overriding: Parameter must be same and performed within subclass(Inheritance). Runt time / Late binding  
 * 
 */
public class PolymorphismDemo {

	public static void main(String[] args) {
		PolymorphismDemo addObj = new PolymorphismDemo(); //Instantiate an object
		addObj.add(45, 45);
		addObj.add(50, 50, 50);
		addObj.add(50.25, 50.25);
		addObj.add(50.25, 50);
		System.out.println("In this class we used same method names using different signature which is an example of compile time Polymorphism");

	}

	//Method with 2 arguments
	public void add(int a, int b){
		int c = a+b;
		System.out.println("PolymorphismDemo. add : Sum of a and b is: " + c);
	}
	
	//Method has different signature. This method has 1 more argument compared to previous method
	public void add(int a, int b, int d){
		int c = a+b+d;
		System.out.println("PolymorphismDemo.add : Sum a, b and d is: "+ c);
	}
	
	//Method has different signature. Different type of argument. This method has double data type
	public void add(double a, double b){
		double c = a+b;
		System.out.println("PolymorphismDemo.add : Sum of a and b is : " + c);
	}
	
	//Method has different signature. Different order of argument. This method has
	
	public void add(int a, double b) {
		double c = a+ b;
		System.out.println("PolymorphismDemo.add : Sum of a and b is : " + c);
		
	}
	
	
	
	
}
