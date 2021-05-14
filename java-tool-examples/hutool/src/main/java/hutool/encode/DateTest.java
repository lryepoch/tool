package hutool.encode;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author lryepoch
 * @date 2020/5/21 15:19
 * @description TODO
 */
public class DateTest {
    public static void main(String[] args) {
        String dateStr = "20201212121212";

        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
