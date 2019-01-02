package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
		int a=0;
		int k=10000/a;
		System.out.println(k);
		}catch(ArithmeticException e)
		{
			//1.로그남기기(파일로 남기기)
			System.out.println("error:"+e);
			//2.사과(정상종료)
			System.out.println("죄송합니다. 예기치 못한 ...");
		
			//3.종료
			return;
			//4. 이거라도 안되면, 
			//e.printStackTrace();
		}finally
		{
			System.out.println("자원정리");
		}
	}

}
