package Collection;

import java.util.Stack;
import java.util.Vector;

public class StackTest {
	public static void main(String[] args) {

		Stack<String> st = new Stack<String>();

		st.push("둘리");
		st.push("또치");
		st.push("희동이");
		
		
		while(!st.isEmpty())
		{
			System.out.println(st.pop());
		}
	

	}
}
