package week3;

class Animals {
	 String name;
	 
	 public void breathing(){ //breathing method is public
		 System.out.println("Animals breath differnetly");
	 }
}	 
//subclass LandAnimal extends from superclass Animals
class LandAnimal extends Animals{ 
         void lbreathing(){ // lbreathing method is private. So, it can't override breathing method from superclass.         	 
             System.out.println(name + " breath on land");
         }
 }

class WaterAnimal extends Animals{
		public void breathing(){ //overriding superclass method
        System.out.println(name + " breath under water");
    }            
}
class AirAnimal extends Animals{
		void abreathing(){
        System.out.println(name + " breath under water");
    }            
}



