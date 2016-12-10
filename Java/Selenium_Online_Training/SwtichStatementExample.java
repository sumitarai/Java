package Day6;
//Program to understand switch statement for the tax compute problem
//Created by: Pallavi
//STH Course on Selenium and Java
import java.util.Scanner;

public class SwtichStatementExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter your category: ");
		Scanner input1 = new Scanner(System.in);
		int category = input1.nextInt();
		
		System.out.print("Enter your income: ");
		int income = input1.nextInt();
		
		double tax=0.0;
		
		switch (category) {
		  case 0: //Single	  		
			 	tax= (income*10)/100;
		  		System.out.println("You have to pay tax amount as: " +tax);
			 	break;
		  case 1: //married
			  tax= (income*5)/100;
			  System.out.println("You have to pay tax amount as: " +tax);
			  break;
			
		  case 2: //separated
			  tax= (income*15)/100;
	  		  System.out.println("You have to pay tax amount as: " +tax);
	  		  break;
	  		  
		  case 3: //widower
			  tax= (income*2)/100;
	  		  System.out.println("You have to pay tax amount as: " +tax);
	  		  break;
	  	
		  default:
	  		System.out.println("Match not found, use 0,1,2 or 3");
		} 

		input1.close();
		
	}

}
