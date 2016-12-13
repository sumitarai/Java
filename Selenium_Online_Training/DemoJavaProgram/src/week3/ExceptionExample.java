package week3;

import java.util.Scanner;

/*
 * Exception handling in java
 */
public class ExceptionExample {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numerator, denomerator, result;
		System.out.print("Enter numerator: ");
		numerator = scan.nextInt();
		System.out.print("Enter denomerator: ");
		denomerator = scan.nextInt();
		
	     try { 
	        // Try block to handle code that may cause exception
	        result = numerator/denomerator; 	        
	        System.out.println("The answer is: "+ result);
	        
	     } catch (ArithmeticException e) { 
	            // This block is to catch divide-by-zero error
	            System.out.println("Error: Don't divide a number by zero " + e);
	       }
	     System.out.println("---------------------------------------------");
	     System.out.println("Now I'm out of try-catch block");
	   
	//This is another exception handling example
	 try{
         int a[]=new int[7];
         a[4]=30/0;
         System.out.println("First print statement in try block");
     }
     catch(ArithmeticException e){
        System.out.println("Warning: ArithmeticException");
     }
     catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Warning: ArrayIndexOutOfBoundsException");
     }
     catch(Exception e){
        System.out.println("Warning: Some Other exception");
     }
   System.out.println("Out of try-catch block...");
   scan.close();
  }
}

