package week3;

import java.util.Scanner;

public class UserDefinedMethods {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Print this line before calling nameAndAddress() method");
		nameAndAddress();
		getAge(0);
		
		
	}
	 //This method returns no value, so it is type void
	public static void nameAndAddress(){
		System.out.println("ABC Company \n123 Happy Street \nOmaha, IL 60014");
	}
	
	//This method returns an int, so it is type int
	public static int getAge( int dobYear){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your DOB year");
		dobYear = scan.nextInt();
		final int currentYear=2016;

		int age = currentYear - dobYear;
		
		System.out.println("Your age is: "+ age);
		
		scan.close(); //switch this with return, you will get error "Unreachable code" - Syntax error because of compilation problem
		
		return age;
		
	} 
	

}
