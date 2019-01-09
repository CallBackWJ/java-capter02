package Collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest {
public static void main(String[] args) {

	List<String> list=new Vector<String>();
	list.add("둘리");
	list.add("마이콜");
	list.add("도우넛");
	list.add("고길동");
	list.add("아줌마");
	
	
	System.out.println("=================순회1=================");
	for(int i=0;i<list.size();i++)
	{
		System.out.println(list.get(i));
	}
	System.out.println("=================순회2=================");
	list.remove(1);
	for(String s:list)
	{
		System.out.println(s);
	}
	
	System.out.println("=================순회3=================");
	Iterator<String> iter=list.iterator();
	while(iter.hasNext())
	{
		String s=iter.next();
		System.out.println(s);
	}
	System.out.println("=================순회4=================");
	
}
}
