package week3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Program written by :Sumita Rai
 * HashMap is an associative arrays that maintains key and value pairs
 * often denoted as HashMap<Key, Value> 
 * 
 */

public class HashmapDemo {
	
	public static void main(String[] args) {
		
		//This is how to declare HashMap
		LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();
		
		/*Adding elements to HashMap 
		"Rob:male:33:engineer:London"
		"Julia:female:29:programmer:New York"
		"Paul:male:45:artist:Sydney"
		"Kavita:female:32:musician:India"
		"Czar:male:25:student:Syria"*/

		hmap.put("Name", "Rob");
		hmap.put("Gender", "male");
		hmap.put("Age", "33");
		hmap.put("Professional", "engineer");
		hmap.put("Place", "London");
		
		hmap.put("Name", "Julia");
		hmap.put("Gender", "female");
		hmap.put("Age", "29");
		hmap.put("Professional", "programmer");
		hmap.put("Place", "New York");
	
		
		for(Map.Entry m:hmap.entrySet()){
			System.out.println(m.getKey() +": " + m.getValue());
			
		}
		
		
	}

}
