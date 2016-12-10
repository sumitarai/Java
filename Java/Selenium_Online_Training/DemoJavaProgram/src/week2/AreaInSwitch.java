package week2;

import java.util.Scanner;

public class AreaInSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length;
		int width;
		int base;
		int height;
		
		double side1;
		double side2;
		double side3;		
		
		int side=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 for Square, 2 for Rectangle, 3 for Triangle");
		side = scan.nextInt();
		
		switch (side){
		case 1: 
			System.out.println("Enter side length: ");
			length = scan.nextInt();
			side1 = length*length;
			System.out.println("Your area of a square is " + side1);
			break;
		case 2:
			System.out.println("Enter length: ");
			length = scan.nextInt();
			System.out.println("Enter width: ");
			width = scan.nextInt();
			side2 = length*width;
			System.out.println("Your area of a rectangle is " + side2);
			break;
		case 3: 
			System.out.println("Enter height: ");
			height = scan.nextInt();
			System.out.println("Enter base: ");
			base = scan.nextInt();
			side3 = 0.5*height*base;
			System.out.println("Your area of a triangle is " + side3);
			break;
		default : 
			System.out.println("Invalid number!");
			break;
		}
		
		scan.close();
	}

}
