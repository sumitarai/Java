package week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmailRegex {

	public static void main(String[] args) throws IOException {
		String file = "C:\\Work\\Selenium_Online_Training\\DemoJavaProgram\\src\\week3\\ValidEmailID.txt";
		String line = null;
		try {
			FileReader fileReader = new FileReader(file);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String expression = "^(.+)@(.+)$"; // expression to emailid

			//bufferedReader has whole content of the file
			//.readLine() reads a line from the bufferedReader
			//if there is a line, then it checks the reg-ex
			while ((line = bufferedReader.readLine()) != null) {
				System.out.print(line);
				String txt = line.toString();
				
				if (txt.matches(expression)) {
					System.out.println("................The line has a valid email-id");
				} else {
					System.out
							.println("...................The line does not have valid email-id");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File unable to open file "+ file);
			e.printStackTrace();
		}

	}

}
