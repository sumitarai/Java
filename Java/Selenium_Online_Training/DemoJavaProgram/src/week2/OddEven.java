package week2;

import java.util.Scanner;
public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lowerRange;
		int upperRange;
		int a;
		int b;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter your lower range ");
		lowerRange= scan.nextInt();
		a=lowerRange;
		System.out.println("Enter your upper range ");
		upperRange= scan.nextInt();
		b=upperRange;
		
		
		System.out.println("The odd numbers in ascending order: ");
		while (lowerRange < upperRange){
			if(lowerRange%2!=0){
				System.out.print(lowerRange + ", ");			
			}lowerRange++;			
		}
		
		lowerRange=a;
		upperRange=b;
		System.out.println("\n");
		System.out.println("The even numbers in descending order: ");
		while (lowerRange < upperRange){
			if (upperRange%2==0){
				System.out.print(upperRange + ", ");
			}upperRange--;
		}			
		scan.close();
	}

}
