package chater02;

public class ArrayUtil {

	static double [] intToDouble( int[] source ){
		double[] d=new double[source.length];
		for(int i=0;i<source.length;i++)
			d[i]=source[i];
		return d;
		
	}

	static int [] doubleToInt( double[] source ){
		int[] i=new int[source.length];
		for(int j=0;j<source.length;j++)
		{
			i[j]=(int)source[j];
		}
		
		return i;
		
	}
	static int [] concat( int[] s1, int[] s2 ){
		int []s3=new int[s1.length+s2.length];
		for(int i=0;i<s1.length;i++)
			s3[i]=s1[i];
		for(int i=0;i<s2.length;i++)
		{
			s3[i+s1.length]=s2[i];
		}
		return s3;
		
	}

}
