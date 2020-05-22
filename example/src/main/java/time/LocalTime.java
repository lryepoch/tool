package time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author lryepoch
 * @date 2019/12/29 14:28
 * @description
 */
public class LocalTime {
    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));

        System.out.println(LocalDateTime.now().getClass().getName());
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getClass().getName());

        System.out.println("----------格式化时间戳---------");
        System.out.println(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));

    }
}