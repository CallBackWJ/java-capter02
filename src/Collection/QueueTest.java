package Collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q=new LinkedList<String>();
	
		q.offer("둘리");
		q.offer("또치");
		q.offer("희동이");
		

		
//		for(String str:q)
//		{
//			System.out.println(str);
//		}
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}
