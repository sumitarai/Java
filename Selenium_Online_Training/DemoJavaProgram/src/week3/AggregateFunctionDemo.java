package week3;

import java.util.Scanner;

public class AggregateFunctionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int marks;
		int totalStudent;
		//int sum= 0;
		int highestMarks = Integer.MAX_VALUE;
		int lowestMarks = Integer.MIN_VALUE;
		//double average=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter students marks: ");
		totalStudent= scan.nextInt();
		marks = scan.nextInt();
		
		lowestMarks= marks;
		
		for( int i=0; i<totalStudent; i++){
			marks= scan.nextInt();
			if(marks>highestMarks){
				highestMarks = marks;
			}if(marks<lowestMarks){
					lowestMarks = marks;
			}
		}
		System.out.println("Highest mark: " + highestMarks);
		System.out.println("Lowest mark: " + lowestMarks);
			/*	sum+=marks;
				totalStudent++;
			}			
			
		
		System.out.println("Total marks are "+ sum);
		
		average = sum/totalStudent;
		System.out.println("The average marks of "+ totalStudent +" students are "+ average);*/
	scan.close();
	}

}
