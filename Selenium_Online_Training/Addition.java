package Day4; 
import java.util.Scanner;

public class Addition{
	public static void main(String[] args){
		
		//Create object of the scanner class
		
		Scanner scan= new Scanner(System.in);// create an object which reads from the console
		//for input console is keyboard
		System.out.println("enter number 1: ");
		
		int num1=scan.nextInt(); //this method converts the entered information into integer datatype
		System.out.println("enter number 2: ");
		int num2=scan.nextInt();
		
		int num3=num1+num2;
		System.out.println("Addition of two numbers is: "+ num3);
		scan.close();
		//close scan object after work is over.
		
		}
	}