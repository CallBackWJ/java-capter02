package javaIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = null;

		try {
			File file = new File("src/javaIO/phone.txt");
			if (file.exists() == false) {
				System.out.println("file not found");
				return;
			}
			System.out.println("====파일정보====");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "byte");
			System.out.println(file.lastModified());

			System.out.println("=====전화번호=====");

			scanner = new Scanner(file);
			// 처리

			while (scanner.hasNextLine()) {

				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();
				System.out.println("이름:" + name + ", " + phone1 + "-" + phone2 + "-" + phone3);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}
}
