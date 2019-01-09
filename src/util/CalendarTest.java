package util;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		printDate(cal);
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 22);
		cal.set(Calendar.HOUR, 5);
		cal.set(Calendar.MINUTE, 10);
		cal.set(Calendar.SECOND, 20);
		printDate(cal);
		cal.set(2016,10,10);
		printDate(cal);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		// TODO Auto-generated method stub
		String [] days={"일","월","화","수","목","금","토"};
		//년도
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);//월(0~11)
 		int date=cal.get(Calendar.DATE);
		int hour=cal.get(Calendar.HOUR);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		int day=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year+"년 "+(month+1)+"월 "+date+"일 "+hour+"시 "+minute+"분 "+second+"초 "+days[day-1]+"요일");
	}
}
