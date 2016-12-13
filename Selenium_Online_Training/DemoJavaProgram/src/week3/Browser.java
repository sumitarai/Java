package week3;

public abstract class Browser {
	String name;
	public abstract void browse();//abstract method has no body
	
	public void setName(String browserName){
		name = browserName;
		}
	public String getName(){
		return name;
	}
	
	public interface Open{
		public void open();
	}
	
}

	

