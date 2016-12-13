package week3;

public class UseFurnitures {

	public static void main(String[] args) {
		
		//instantiation of a subclass object		
		HomeFurniture fur1 = new HomeFurniture();
		fur1.place = "home";
		fur1.attributes();
		
		OfficeFurniture fur2 = new OfficeFurniture();
		fur2.place = "office";
		fur2.attributes();
		
		OutdoorFurniture fur3 = new OutdoorFurniture();
		fur3.place ="outdoor";
		fur3.attributes();

	}

}
