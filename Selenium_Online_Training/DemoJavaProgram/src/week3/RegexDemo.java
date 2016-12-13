package week3;
/*Write a program which prints valid, for a valid ssn number as provided by the end user 
 * and invalid for junk 
 */
import java.util.*;

public class RegexDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter  a social security number: ");
		String ssn = scan.next();
	
		String expression = "[0-9]{3}-[0-9]{2}-[0-9]{4}"; //initialize reg ex for SSN
		
		if (ssn.matches(expression)){
			System.out.println(ssn + " is a valid SSN");
		}else{
			System.out.println(ssn + " is a invalid SSN");
		}		
		scan.close();
	}
}

