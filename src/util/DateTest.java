package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {

		Date now = new Date(117, 11, 19);
		System.out.println(now);

		printDate(now);
		printDate1(now);
		printDate2(now);
	}

	private static void printDate2(Date d) {
		// TODO Auto-generated method stub
		// 년도(+1900)
		int year = d.getYear();
		// 월(0~11,+1)
		int mouth = d.getMonth();
		// 일
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();
		System.out
				.println((year + 1900) + "-" + (mouth + 1) + "-" + date + " " + hours + ":" + minutes + ":" + seconds);

	}

	private static void printDate1(Date d) {
		// TODO Auto-generated method stub

	}

	private static void printDate(Date d) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String s = sdf.format(d);
		System.out.println(s);
	}
}
