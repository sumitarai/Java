package week2;

import java.util.Scanner;

public class SmallestVal {

	public static void main(String[] args) {
		
		int valueOne;
		int valueTwo;
		int valueThree;
		int smallNum;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first number: ");
		valueOne = scan.nextInt();
		
		System.out.println("Enter your second number: ");
		valueTwo = scan.nextInt();
		
		System.out.println("Enter your third nmber: ");
		valueThree = scan.nextInt();
		
		if (valueOne < valueTwo){
			smallNum = valueOne;			
		}else{
			smallNum = valueTwo;
		}
		
		if (smallNum < valueThree){
			System.out.println("The smallest value is " + smallNum);
		}else{
			System.out.println("The smallest value is " + valueThree);
		}
		
		scan.close();
	}
}
