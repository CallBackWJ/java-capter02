package chaptor03;

public class StringTest03 {

	public static void main(String[] args) {
		String s="aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc",7));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,5));
		
		String s2="    ab cd     ";
		String s3="efg,hij,lmno,pq";
		
		String s4=s2.concat(s3) ;
		System.out.println(s4);
		String s5=s4.trim();
		System.out.println(s5);
		System.out.println(s4.replaceAll(" ", ""));
		
		String[] tokens=s3.split(",");
		for(String str:tokens)
		{
			System.out.println(str);
		}
		
		
		System.out.println("--------------------stringBuffer----------------------");
		StringBuffer sb=new StringBuffer();
		sb.append("Hello");
		sb.append(" World");
		sb.append(2018);
		System.out.println(sb);
		
		//Stirng str="Hello" + "World"+2018;
		String str=new StringBuffer("Hello ").append("World").append(2018).toString();
		
		
		String str2="";
		StringBuffer sb2=new StringBuffer("");
		for(int i=0;i<100000;i++)
		{
			//str2=str2+i; /JVM이 아래와 같이 자동 치환 시킴;
			//String str2=new StringBuffer(str2).oppend(i); //반복문 내에서 생성자가 계속 호출되어 속도가 저하된다.
			sb2.append(i);
		}
		
		System.out.println("종료");
		
	}
}
