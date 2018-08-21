/* 4/5/2018
 * This class show how to pass parameter in order make program dynamic
 *  
 */
public class ParameterDemo {

	public static void main(String[] args) 
	{
		ParameterDemo objpara = new ParameterDemo();
		objpara.add(10, 5);			// Pass the parameter value while Calling parameter from main method
		objpara.sub(25.7, 10.2);
		
		int sum = objpara.sum(30, 20);  // Store data objpara.sum value in sum
		System.out.println("ParameterDemo.sum : Sum method parameter value passed and store the parameter in sum: " + sum);
		
		
		DynamicCalculator objDynamicCal = new DynamicCalculator();  // instantiate an object of DynamicCalculator class
		int total = objDynamicCal.sum(100, 150);
		System.out.println("ParameterDemo : Non-static : Call parameter from DynamicCalculator class and store return value in total: " + total);
		
		int stotal = objDynamicCal.sub(500, 200);
		System.out.println("ParameterDemo : Non-static : Call parameter from DynamicCalculator class and pass and return value which stores in stotal: " + stotal);
		
		String FullName = DynamicCalculator.getName("Sumi", "Rai");
		System.out.println("ParameterDemo : Static : Call parameter from DynamicCalculator class and pass value of FullName: " + FullName);
		
		
	}
	
	
	//Example of using parameter and calling those parameter from main method
	public void add(int a, int b){  //Use parameter a and b
		int c = a + b;				// c is a local variables and couldn't access from main method because of void return type
		System.out.println("ParameterDemo.add : The sum of a and b is " + c);
		System.out.println("The value of c is a local variable and cannot be accessible from main method bcause it has void return type");
	}	
	public void sub(double x, double y){	//Use parameter x and y
		double z = x - y;
		System.out.println("ParameterDemo.sub : The sub of x and y is " + z);		
	}
	
	
	
	
	// Example of return type which will return value from method
	public int sum(int a, int b){
		int d = a+b;		//d is a local variable and can be access because it returns int values
		System.out.println("ParameterDemo.sum : The sum of a and b is " + d);
		System.out.println("The value of d is a local variable but it can be accessible from main method because it returns value");
		return d;
		
	}
	
	
	
	
	

}
