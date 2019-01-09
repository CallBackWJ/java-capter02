package javaIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// 기반 스트림 (표준입력, stdin,System.in)

			// 보조스트림1

			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			// 보조스트림2(char|char|char|......|\n -> "charcharchar")
			br=new BufferedReader(isr);

			//read
			String line=null;
			while((line=br.readLine())!=null)
			{
				if("exit".equals(line))break;
			}
					
			
			System.out.println(">>"+line);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error:" + e);
		}finally {
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
