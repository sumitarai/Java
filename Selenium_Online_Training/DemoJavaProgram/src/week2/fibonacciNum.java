package week2;

public class fibonacciNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;
		int num2=1;
		int sum;
		
		
		System.out.println("The fibonacci numbers are ");
		for(int i=0; i<=10; i++){
		sum= num1+num2;
		System.out.print(sum + " ");
		if (i%2==0){
			num1=sum;
		}else{
			num2=sum;
		}
		
		}
	}

}
