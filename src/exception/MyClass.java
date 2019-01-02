package exception;

public class MyClass {

	public void dangerMethod() throws MyException
	{
		System.out.println("nomal state1");
		
		throw new MyException("예외발생");
	}
}
