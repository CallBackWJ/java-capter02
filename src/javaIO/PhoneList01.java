package javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
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

			// 기반스트림(byte)
			FileInputStream fis = new FileInputStream(file);
			// 보조스트림1(bytes->char)
			InputStreamReader isr = new InputStreamReader(fis);

			// 보조스트림 (라인입력)
			br = new BufferedReader(isr);

			// 처리
			String line = null;

			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int idx = 0;
				while (st.hasMoreElements() == true) {
					String token = st.nextToken();
					System.out.print(token);
					if (idx == 0) {
						System.out.print(": ");
					} else if (idx == 1) {
						System.out.print("-");
					} else if (idx == 2) {
						System.out.print("-");
					}
					idx++;
				}
				System.out.println();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
