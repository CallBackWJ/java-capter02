package Collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class OldVectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<String> list=new Vector<String>();
		list.addElement("둘리");
		list.addElement("마이콜");
		list.addElement("도우넛");
		list.addElement("고길동");
		list.addElement("아줌마");
		
		System.out.println("=================순회1=================");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.elementAt(i));
		}
		
		System.out.println("=================순회2=================");
		
		list.removeElementAt(1);
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
		Enumeration<String> e=list.elements();
		while(e.hasMoreElements())
		{
			String s=e.nextElement();
			System.out.println(s);
		}
		

	}

}
