package others;

import java.sql.Date;


public class NextDay {
	public static Date getNextDay(){
		try{
		Thread.sleep(24*60*60*1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new Date(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextDay.getNextDay();

	}

}
