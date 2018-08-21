
public class LoopAndIfCondition {

	public static void main(String[] args) {
		
		int x1 = 5;					//decrement while loop
		while(x1>0){
			x1=x1-1;
			System.out.println("X value is "+x1);
		if (x1>2){
			System.out.println(" X value is "+ x1);
		}
		if(x1==2){
			System.out.println("X value is now "+ x1);
		}
		if (x1<2){
			System.out.println("X value is " + x1);
			x1=x1-1;
		}
		
		}
		
		
		
	
		int x = 0;
		int y =0;
		while (x<5){
			x=x+1;
			y=y+x;
			System.out.println("x: "+ x+ "; "+ "y: " + y);
			
		}
		
		int a =0;
		int b =0;
		while (a<5){
			b=a-b;
			System.out.println("a: "+ a+ "; "+ "b: " + b );
			a= a+1;
			
		}
		
		
		int c =0;
		int d =0;
		while (c<5){
			d=d+c;
			System.out.println("c: "+ c+ "; "+ "d: " + d );
			c= c+1;
			
		}
	}

}
