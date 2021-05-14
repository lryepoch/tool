package hutool.util;

import cn.hutool.core.convert.Convert;
import hutool.constant.Comment;
import org.junit.Test;

/**
 * @author lryepoch
 * @date 2020/5/21 16:25
 * @description TODO
 */
public class ConverterTest {
    @Test
    @Comment("转换为字符串")
    public void test1() {
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        int[] b = {1,2,3,4,5};
        String bStr = Convert.toStr(b);
        System.out.println(bStr);

        Object c = null;
        String cStr = Convert.toStr(c,"空字符串(默认值)");
        System.out.println(cStr);
    }
}
