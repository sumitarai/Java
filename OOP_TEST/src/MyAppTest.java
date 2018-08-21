
public class MyAppTest {

	public static void main(String[] args) {
		
				
		//declare integer variable named "x" and assigned the value of 25
		int x = 25;
		x = x * 4;     // x value is 25x4=100
		System.out.println("The value of an 'x' is: " + x); // this will print out the value of x which is 100
		Utility.writeLog("The value of an 'x' is: " + x) ;   //Use the Utility class to write log
		
		
		double d = Math.random();  //this will give the random number of double variable
		System.out.println(" Value of d is: " + d); 
		
		//declare String character variable named "name" and assigned value of "Sumita"
		String name = "Sumita";
		System.out.println("Hello " + name + "!");
		
		//while loop
		while (x>12){
			x=x-1;  // here is x value is 100-1=99
			System.out.println("In the loop");
			System.out.println("x value is: "+ x); // it will loop and print the value of x from 99 to 12 because x value was 100 which is greater than 12
		}
		
		int z = 10;
		while (z<12) {
			z=z+1;
			System.out.println("In the loop");
			System.out.println("z value is " + z);
			
		}
		
		//for(int x=0; x=20; x=x+1){
			//System.out.println("x value is: " + x);}
		
		//if/else condition
		if (x==12){
			System.out.println("x value is equal to 12");
		}else {
			System.out.println("x value is not equal to 12");
		}
		
		
		// String condition compared 
		String name1 = "sumita";
		if (name1.equalsIgnoreCase("Sumita")){
			System.out.println("Name is :" + name1);
		}else {
			System.out.println("Not " +name1);
			
		}
		
		
			
			int beerNum = 5;
		     String word = "bottles";

		   while (beerNum > 0) {

		      if (beerNum == 1) {
		        word = "bottle"; // singular, as in ONE bottle.
		      }

		      System.out.println(beerNum + " " + word + " of beer on the wall");
		      System.out.println(beerNum + " " + word + " of beer.");
		      System.out.println("Take one down.");
		      System.out.println("Pass it around.");
		      beerNum = beerNum - 1;

		      if (beerNum > 0) {
		         System.out.println(beerNum + " " + word + " of beer on the wall");
		      } else {
		         System.out.println("No more bottles of beer on the wall");
		     } // end else
		   } // end while loop
		
			
	}
}
