/* 04/06/2018
 * This class will demo Array. It is a collection of similar type of datatypes
 * 
 */

public class ArrayDemo {

	public static void main(String[] args) {
		/* Limitation of array
		 * Limitation of size. Need to know the exact size of array in order to retrieve the data. Otherwise it will throw outofboundexception error
		 * Limitation of type. We cannot assign different data type unless we type cast. 
		 */
		
		
		//One Dimension Array
		int students_id[] = new int[5];
		//students_id[0] = (int) 50.5; //In this case it is a collection of int data type and in order to assign different data type we must type cast
		students_id[0] = 50;
		students_id[1] = 60;
		students_id[2] = 70;
		students_id[3] = 80;
		students_id[4] = 90;
		
		System.out.println("Students id 3: "+ students_id[3]);
		
		int sizeofArray = students_id.length;
		System.out.println("The length of array is " + sizeofArray);
		
		for(int i = 0; i<sizeofArray; i++){
			System.out.println("Student id " + i + " is "+ students_id[i]);
		}
		
		String names[] = new String[3];
		names[0]= "Sumi";
		names[1]= "Mimi";
		names[2]= "Lisa";
		
		//int nameLength = names.length;
		for (int i = 0; i < names.length; i++) {
			System.out.println("Name in "+ i + " array is "+ names[i]);
			
		}
		
		
		//2-Dimensional Array
		int school[][]= new int[3][2]; //3 Row and 2 Column		
		school[0][0]=50;
		school[0][1]=60;
		school[1][0]=70;
		school[1][1]=80;
		school[2][0]=90;
		school[2][1]=100;
		
		System.out.println("School id is " + school[1][1]);
		
		//int schoolLength = school.length;
		for (int i = 0; i < school.length; i++) {
			for (int j = 0; j < school[i].length; j++) {
				System.out.println("Array School [" + i +"][" + j +"] is " + school[i][j]);
			}
			
		}		
		
	}

}
