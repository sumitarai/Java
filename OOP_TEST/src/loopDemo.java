/*
 * This class shows For loop, while loop and Do while loop
 * It allow you to run certain code multiple times.
 * 
 */
public class loopDemo {

	public static void main(String[] args) {
	
		
	// Example of For loop
	System.out.println("For Loop started..");		
	for(int i=2; i<20; i++){
		System.out.println("i value is "+ i);
	}		
	System.out.println("For Loop ended");		

	
	//Example of While loop. It will only execute only if the condition is true
	int count= 60;
	System.out.println("While loop started..");
	while (count<70){
		System.out.println("Count value is "+ count);
		count++;
	}
	System.out.println("While loop ended");
	
	
	//Example of do..while loop
	
	int ticket = 90;
	System.out.println("do..while loop started...");
	do{
		System.out.println("Current ticket is "+ ticket);
		ticket++;
	}while(ticket <=100);
	System.out.println("do..while loop ended");
	
	
	
	
	}

}
