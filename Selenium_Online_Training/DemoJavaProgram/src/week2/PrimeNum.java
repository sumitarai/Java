package week2;

import java.util.Scanner;

public class PrimeNum {
//Prime number is greater than 1 and divided by 1 and itself
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startRange;
		int endRange;
				
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter your start range ");
		startRange= scan.nextInt();
		
		System.out.println("Enter your end range ");
		endRange= scan.nextInt();
		
		System.out.println("The prime numbers: ");
		
		for(int i=2; i<=endRange; i++){
			for (int j=2; j<=i; j++){
				if (i==j){
					System.out.print(i +" ");
				}
				if (i%j==0){
					break;
				}
			}
			
		}
		scan.close();
}
}
