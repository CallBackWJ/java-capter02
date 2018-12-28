package chater02;


public class UtilTest {

	public static void main(String[] args) {
		int[] a1={10,11,12,13};
		double[]d1 =ArrayUtil.intToDouble(a1);
		for(double dd:d1)
		{
			System.out.print(dd+" ");
		}
			
		System.out.println();
		double[] d2={10.1,11.1,12.2,13.3};
		int[] a2=ArrayUtil.doubleToInt(d2);
		for(int aa:a2)
		{
			System.out.print(aa+" ");
		}
		System.out.println();
		int [] a3= ArrayUtil.concat(a1, a2);
		for(int a:a3)
		{
			System.out.print(a+" ");
		}
		
		
		
	}
}
