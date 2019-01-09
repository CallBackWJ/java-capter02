package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class InputStreamReaderTest {
	public static void main(String[] args) {

		InputStreamReader isr=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("");
			isr=new InputStreamReader(fis,"MS949");
			
			int data=-1;
			while((data=isr.read())!=-1)
			{
				System.out.print((char)data);
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(isr!=null)
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
