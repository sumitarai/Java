package week3;

public class MatrixTransposeDemo {

	public static void main(String[] args) {
					
			
			int[][] original = new int[][] { { 0, 1, 2}, {3, 4, 5} };// arr is a variable name that is initialized with 3 rows and 2 cols values
	        
			
			System.out.println("The original Array matrix: ");
			for (int i = 0; i < original.length; i++) {
	            for (int j = 0; j < original[i].length; j++) {
	                System.out.print(original[i][j] + " ");
	            }
	            System.out.print("\n");
	        }
			System.out.println();
	        
	        // transpose
	        if (original.length > 0) {
	        	System.out.println("Matrix transpose: ");
	            for (int i = 0; i < original[0].length; i++) {
	                for (int j = 0; j < original.length; j++) {
	                    System.out.print(original[j][i] + " ");
	                }
	                System.out.print("\n");
	            }
	        }	
	        
	    	//System.out.println(original.length);
			//System.out.println(original[0].length);
	}
			
}


