package week2;

import java.util.Scanner;
public class AreaFigure {

	public static void main(String[] args) {
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
		
		if (side == 1){
			System.out.println("Enter side length: ");
			length = scan.nextInt();
			side1 = length*length;
			System.out.println("Your area of a square is " + side1);
		}else if (side ==2){
			System.out.println("Enter length: ");
			length = scan.nextInt();
			System.out.println("Enter width: ");
			width = scan.nextInt();
			side2 = length*width;
			System.out.println("Your area of a rectangle is " + side2);
		}else if (side ==3){
			System.out.println("Enter height: ");
			height = scan.nextInt();
			System.out.println("Enter base: ");
			base = scan.nextInt();
			side3 = 0.5*height*base;
			System.out.println("Your area of a triangle is " + side3);
		}else{
			System.out.println("Invalid number!");
		}
		
		scan.close();
	}

}
