/* 04/04/2018
 * This class shows the String class 
 * http://essentialsoftwaretesting.blogspot.in/2017/08/string-class-in-java-and-usage-in.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 */
public class stringDemo {

	public static void main(String[] args) {
		
		//Example of startsWith() and ends() method which will return true and false
		String name = "Selenium Webdriver";		// Declare String variable name and initialize
				
		boolean status = name.startsWith("selenium");    // It will return true or false 
		System.out.println("Current status is " + status);
		
		String greet = "Welcome to Selenium webdriver";
		boolean status1 = greet.endsWith("webdriver");   // It will return True because condition satisfied 
		System.out.println("New status1 is "+ status1);		
		
		
		//Example of Equals() and EqualsIgnoreCase - will compare the content only and will return true and false
		String expectedRslt = "Welcome to Selenium Webdriver World";
		String actualRslt = "Welcome to selenium webdriver world";
		boolean status2 = actualRslt.equalsIgnoreCase(expectedRslt);
		System.out.println("actualRslt equal to expectedRslt is " + status2);
		
		String expectedRslt1 = "Sumi";
		String actualRslt1 = "Welcome Sumi to CSC";
		boolean status3 = actualRslt1.contains(expectedRslt1);  // if actual result contains expected result then continue with testing code 
		System.out.println(status3);
		
		
		//Example of Split() - will return array of string
		String fullname = "Selenium-HP-QTP";
		String [] toolname = fullname.split("-");
		for(int i=0; i<toolname.length; i++){
			System.out.println("Value for " + i + " is " + toolname[i]);
				if(toolname[i].equalsIgnoreCase("Selenium")){
					System.out.println("Test passed");
					// break;
				}
		}
		
		// Example of trim() - eliminates white spaces before and after string
		String FN = " Sumi Rai ";
		String fName = FN.trim();
		System.out.println(FN); 
		System.out.println(fName);
		
		
		//Example of charAt() - returns a character at specified index position
		String namechar = "Miru Rai";
		System.out.println(namechar.charAt(6));
		
		
		
		

	}

}
