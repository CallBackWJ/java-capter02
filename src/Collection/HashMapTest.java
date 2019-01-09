package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {

		Map<String,Integer> m=new HashMap<String,Integer>();
		m.put("one", 1);
		m.put("two", 2);
		m.put("three", 3);
		
		Integer i=m.get("two");
		System.out.println(i);
		m.put("three", 33333);
		Integer i1=m.get("three");
		System.out.println(i1);
		
		Set<String > keys=m.keySet();
		
		for(String key:keys)
		{
			System.out.println(m.get(key));
		}
		
		
	}
}
