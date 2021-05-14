package time;

import java.util.Calendar;

/**
 * @author lryepoch
 * @date 2021/3/11 16:04
 * @description TODO
 */
public class CurrentTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
    }
}
