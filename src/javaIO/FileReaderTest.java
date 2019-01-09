package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader is = null;
		//InputStream is = null;
		
		int count=0;
		try {
			is = new FileReader("/Users/choi/Desktop/cc.txt");
			//is = new FileInputStream("/Users/choi/Desktop/cc.txt");
			
			int data = -1;
			while ((data = is.read()) != -1) {
				//os.write(data);
			
			
				System.out.print((char)data);
				count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류." + e);
		}  finally {

			System.out.println("\ncount is:"+count);
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
