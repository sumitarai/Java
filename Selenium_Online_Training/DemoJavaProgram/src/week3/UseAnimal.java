package week3;


public class UseAnimal {

	public static void main(String[] args) {
			Animals a =new Animals();
			a.breathing();
			
			LandAnimal la= new LandAnimal();
			la.name ="Land animals";
			la.lbreathing();
			
			
			WaterAnimal wa= new WaterAnimal();
			wa.name ="Water animals";
			wa.breathing();
			
			AirAnimal aa= new AirAnimal();
			aa.name ="Air animals";
			aa.abreathing();
		}
}


