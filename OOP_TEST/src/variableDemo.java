/* this class shows different type of data type. 
 * Variable is a memory location to store values. It has data type and names
 * All 8 data type example 
 * Local and global variables
 * 
 */
public class variableDemo {
	
	static int gnum;

	public static void main(String[] args) {
		
		// boolean data type example		//1 bit  (T/F)
		boolean status;   // declaration variable		
		status = true;  // initialization of boolean type variable status
		
		boolean newStatus = false;  // standard way to declare and initialized the variable
		
		System.out.println("My old status was " + status);
		
		System.out.println("My new status is " + newStatus);
		
		// char data type example   //2byte (0 to 65536)
		char a ='A';
		char b= 'B';
		char c = 65;    // if char is assigned to number then based on ASCII code table it will assign the number to respective letter. 65 is assigned to A
		System.out.println("First char value is "+ a);
		System.out.println("Second char value is  "+ b);
		System.out.println("Third char value is " + c);
		
		
		//int data type example
		byte bnum = 98;									//1 byte  (-128 to 127)
		System.out.println("First number is byte: "+ bnum );
		
		short snum = 150;								//2 byte (-32768 to 32767)
		System.out.println("Second number is short: " +snum);  //byte snum = 150; will give error because it is out of range to byte
		
		int inum = 899999998;						 	//4 byte (-2,147,483,648 to 2,147,483,647)
		System.out.println("Third number is int: " + inum);
		
		long lnum = 899999999; 							//8 byte (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
		System.out.println("Forth number is long: "+ lnum);
		
		
		//float datat type example
		float fnum = 60.55f;  // f is a floating value
		float fnumm = (float)70.55; // use (float) type casting so java won't change it to double     
		double dnum = 90.55;
		System.out.println("First num is float type casting "+ fnum);
		System.out.println("Second num use f for floating value "+ fnumm);
		System.out.println("Thirs num is double "+ dnum);
		
		//downcasting converting from higher data type to lower data type
		int d = (int)4.99;  //(int) type casting 
		System.out.println("Down casting example: " + d);
		
		/*Local variable: applicable within method level. It contains garbage values if the variable is not initialized
		 * Global variable: applicable within class level. It contains null/ default value which can be set to 0 if the variable is not initialized
		 */		
		
		int i= 100;
		System.out.println("Local variable value is "+ i);
		System.out.println("Global variable value is not initialized and value is by default is "+ gnum);
		

	}

}
