package javaIO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("/Users/choi/Desktop/aa.jpg");
			os = new FileOutputStream("/Users/choi/Desktop/bb.jpg");
			int data = -1;
			while ((data = is.read()) != -1) {
				os.write(data);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다." + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다." + e);
		} finally {

			try {
				if (is != null)
					is.close();

				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
