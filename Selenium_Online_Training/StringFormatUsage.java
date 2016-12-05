
public class StringFormatUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Printing Integer using % d specifier
		int a=10;
		int b =20;
		int c= a+b;
		System.out.printf("Sum of two numbers %d and %d is equal to %d ",a,b,c);
		System.out.println("\n");
		
		//Printing float using %f specifier
		double e=10.5;
		double f =200.4;
		double g= e/f;
		System.out.printf("Dividing  %f by %f is equal to %f ",e,f,g);
		
		System.out.println("\n");
		//Printing boolean using %b specifier
		boolean m=true;
		boolean n =false;
		boolean o = (m&&n);
		System.out.printf("Performing AND operation on values %b, %b, we get %b" ,m,n,o);
	}

}
