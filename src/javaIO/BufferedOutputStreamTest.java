package javaIO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {

		FileOutputStream fos = null;
		BufferedOutputStream bos=null;

		try {
			fos = new FileOutputStream("/Users/choi/Desktop/dd.txt");
			bos=new BufferedOutputStream(fos);
			for(int i='a';i<='z';i++)
				bos.write(i);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not Fount:" + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException e:" + e);
			e.printStackTrace();
			System.out.println("File Not Fount:" + e);
		} finally {
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
