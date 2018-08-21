/* 04/06/2018
 * http://essentialsoftwaretesting.blogspot.in/2017/08/inheritance-in-java-single-level.html
 * 
 * This class will demo inheritance. This is a parent class
 * Inheritance is a basic concept of OOP which will allow to use the parent class features
 * Inheritance allow to use parents class variables and methods using child class object 
 * Used for code reusebility, no code duplication, and method overriding
 * 
 * 
 * This is a Child class which contain Main method
 * Child class reference and child class object will allow to access all the method of base/parent class and child class
 */


public class InheritanceDemo extends ParentClass {

	public static void main(String[] args) {
			
		//Child class object and reference allow to access both base class and child class methods
		InheritanceDemo childClass = new InheritanceDemo();  //Creating a child class object allow to inherit methods from parent class and child class both
		childClass.add();
		childClass.sub();
		childClass.mult();
		childClass.div();
		
		
		//Parent class object and reference allow to access base class method only NOT from child class
		ParentClass parentClass = new ParentClass();
		parentClass.add();
		parentClass.sub();
		
		
		//Parent class reference and child class object allow to access base class methods only and NOT from child class. 
		ParentClass obj1 = new InheritanceDemo();
		obj1.add();			//this is a parent class method
		obj1.sub();			//this is a parent class method
		//obj1.mult();      // this is a child class method
		//obj1.div();		//this is a child class method
		

	}
	
	
	//Methods from Child Class
	public void mult(){
		System.out.println("InheritanceDemo.mult : This is mult method from Child class");
	}
	
	public void div(){
		System.out.println("InheritanceDemo.div : This is div method from Child class");
	}
	
	
	
	
	
	
}
