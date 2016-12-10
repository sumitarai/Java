package week3;

import java.util.Scanner;

public class StringIndex {

	public static void main(String[] args) {
		
		//print those strings which start with 'R'	
		Scanner scan = new Scanner (System.in);
		String[] entries = new String[10];
		
		int size = entries.length;
		
		for(int i=0; i<size; i++){
		
		System.out.print("Enter your word: ");		
		entries[i] = scan.next(); 
		System.out.println("Your entered: "+ entries[i]);
			
			char aChar= entries[i].charAt(0);			
			if (entries[i].charAt(0)=='R'){
				System.out.println("Your word " + entries[i]+ " starts with "+ aChar);			
			} 			
	}	scan.close();
}
}
