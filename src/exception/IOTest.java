package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
			int data=fis.read();
			System.out.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
}
