package week3;

import week3.Browser.Open;

public class FireFox extends Browser implements Open{
	
	public void browse(){
	
		System.out.println(name+ " is a browser that");
		}
	public void open(){ //open method is implemented from Open interface
		System.out.println("opens web page.");
	}
}


