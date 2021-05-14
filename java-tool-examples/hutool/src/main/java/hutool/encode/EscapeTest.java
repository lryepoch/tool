package hutool.encode;

import cn.hutool.core.util.EscapeUtil;
import hutool.constant.Comment;
import org.junit.Test;

/**
 * @author lryepoch
 * @date 2020/5/21 16:06
 * @description TODO
 */
public class EscapeTest {
    @Test
    @Comment("转义与反转义")
    public void test2() {
        String s1 = "<script>location.href='http://how2j.cn';</script>";
        String s2 = EscapeUtil.escapeHtml4(s1);
        System.out.println(s2);

        String s3 = EscapeUtil.unescapeHtml4(s2);
        System.out.println(s3);

    }
}
