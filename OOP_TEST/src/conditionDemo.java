
/*This class demo condition/decision statement 
 * Based on the condition, we are able to decide if we want to run the code or not. It checks the if condition is true then execute the code 
 * Example: 
 * Fetch the database record only if the DB connection is successful
 * Run the TC only if the browser is not equal to null
 * Fetch the record only if the excel sheet is available
 * 
 * 
 */

public class conditionDemo {

	public static void main(String[] args) {
		
		//if/if condition example
		System.out.println("if condtion started...");
		int i= 90;
		if (i<100){
			System.out.println("The first if block value of i is "+ i);			
		}if (i<50){
			System.out.println("The second if block value of i is "+ i);
		}
		System.out.println("if condition test ended");
	
	
	
		//if/else condition example
		String browser = "SumiIEChromeFirefox";
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("TC executed on Chrome");
		}else if (browser.equalsIgnoreCase("Firefox"))
		{
			System.out.println("TC executed on Firefox");
		}else if (browser.equalsIgnoreCase("IE"))
		{
			System.out.println("TC executed on IE");
		}else{
			System.out.println("Please provide valid browser name");
		}
		
		
		
		//switch condition example
		int x=4;
		switch(x)
		{
		case 1:
			System.out.println("Performace is poor");
			break;
		case 2:
			System.out.println("Slow Performance");
			break;
		case 3:
			System.out.println("Meeting expection");
			break;
		case 4:
			System.out.println("Perfomace is good");
			break;
		case 5:
			System.out.println("Well done! Employee of the year");
			break;
			
		default:
			System.out.println("Employee is inactive");
		
		}
		
		
	}

}
