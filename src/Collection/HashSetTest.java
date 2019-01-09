package Collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		String s1=new String("고길동");
		String s2=new String("고길동");
		String s3=new String("고길동");
		
		s.add("둘리");
		s.add("마이콜");
		s.add(s1);
		//s.add(s2);
		System.out.println(s.contains(s2));
		System.out.println(s.size());
		s.remove(s3);
		
		for(String ss:s)
		{
			System.out.println(ss);
		}
		
	}
}
