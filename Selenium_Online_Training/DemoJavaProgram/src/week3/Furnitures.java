package week3;
/*
 * Create a class for Furniture, and create child classes as follows - HomeFurniture, OfficeFurniture, OutdoorFurniture
 */

public class Furnitures {
	String place; //field attributes
	
	public void attributes(){ //method function of a superclass
		System.out.println("Furnitures defined based on their locations");
	}
}

//different subclasses extended from a superclass
class HomeFurniture extends Furnitures{
	public void attributes(){ // method overriding 
		super.attributes(); //invoke superclass method
		System.out.println("Home furniture is at " + place);
	}
}

class OfficeFurniture extends Furnitures{
	public void attributes(){
		System.out.println("Office furniture is at " + place);
	}
}

class OutdoorFurniture extends Furnitures{
	public void attributes(){
		System.out.println("Outdoor furniture is " + place);
	}
}
