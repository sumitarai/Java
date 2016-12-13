package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Program written by :Sumita Rai
 * HashMap is an associative arrays that maintains key and value pairs
 * often denoted as HashMap<Key, Value> 
 * 
 */

public class ArrayOfHashMap {
	
	public static void main(String[] args) {
		
				
		//Create an array of hashmap
		List<Map<String,String>> listOfMaps = new ArrayList<Map<String, String>>();
		
		//This is how to declare HashMap
		HashMap<String, String> hmap = new HashMap<String, String>();
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
		listOfMaps.add(hmap);
		
		HashMap<String, String> hmap1 = new HashMap<String, String>();
		hmap1.put("Name", "Julia");
		hmap1.put("Gender", "female");
		hmap1.put("Age", "29");
		hmap1.put("Professional", "programmer");
		hmap1.put("Place", "New York");	
		listOfMaps.add(hmap1);
		
		HashMap<String, String> hmap2 = new HashMap<String, String>();
		hmap2.put("Name", "Paul");
		hmap2.put("Gender", "male");
		hmap2.put("Age", "45");
		hmap2.put("Professional", "artist");
		hmap2.put("Place", "Sydney");	
		listOfMaps.add(hmap2);
		
		HashMap<String, String> hmap3 = new HashMap<String, String>();
		hmap3.put("Name", "Kavita");
		hmap3.put("Gender", "female");
		hmap3.put("Age", "32");
		hmap3.put("Professional", "musician");
		hmap3.put("Place", "India");	
		listOfMaps.add(hmap3);
		
		HashMap<String, String> hmap4 = new HashMap<String, String>();
		hmap4.put("Name", "Czar");
		hmap4.put("Gender", "female");
		hmap4.put("Age", "29");
		hmap4.put("Professional", "programmer");
		hmap4.put("Place", "New York");	
		listOfMaps.add(hmap4);

		
		/*
		for(Map.Entry m : hmap.entrySet()){
			System.out.println(m.getKey() +": " + m.getValue());
			
		}
		*/
		
		Map<String,String>[] maps = listOfMaps.toArray(new HashMap[listOfMaps.size()]);
		System.out.println("Total records = "+ maps.length);
		System.out.println("======================");
		for(int i=0; i < maps.length; i++)
		{
			System.out.println("Record#"+ (i+1));
			for(Map.Entry m : maps[i].entrySet()){
				System.out.println(m.getKey() +": " + m.getValue());
			}
			
			System.out.println("======================");
			
		}
		
	}

}
