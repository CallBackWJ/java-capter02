package util;

public class SingletonTest {
	public static void main(String[] args) {
		//Singleton obj=new Singleton();
		Singleton obj1=Singleton.getInstance();
		Singleton obj2=Singleton.getInstance();
		
	
		System.out.println(obj1==obj2);
	}
}
