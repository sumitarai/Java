/*This class shows how to use dynamic parameter and can be called from ParameterDemo
 * 
 */
public class DynamicCalculator{
		public int sum(int num1, int num2)
		{
			int total = num1 + num2;
			System.out.println("DynamicCalculator.sum : Parameter is used in separate class and called from separate main method");
			return total;			
		}
		
		
		public int sub(int num3, int num4)
		{
			int stotal= num3 - num4;
			return stotal;
		}
		
		
		//Static method example with parameter
		public static String getName(String FN, String LN){
			String FullName = FN + " " +  LN;
			return FullName;
		}


}
