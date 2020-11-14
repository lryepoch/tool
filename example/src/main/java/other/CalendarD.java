package other;

import java.util.Calendar;

public class CalendarD {
	public static void main(String[] args) {
		
		
		Calendar now=Calendar.getInstance();
		//am or pm
		int ampm=now.get(Calendar.AM_PM);
		
		//时
		int hour=now.get(Calendar.HOUR_OF_DAY);
		
		//日
		int day=now.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(ampm);
		System.out.println(hour);
		System.out.println(day);

	}

}
