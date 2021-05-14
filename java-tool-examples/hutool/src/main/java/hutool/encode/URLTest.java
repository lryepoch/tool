package hutool.encode;

import cn.hutool.core.util.URLUtil;
import hutool.constant.Comment;
import org.junit.Test;

/**
 * @author lryepoch
 * @date 2020/5/21 16:09
 * @description TODO
 */
public class URLTest {

    @Test
    @Comment("URLUtil使用举例")
    public void test1() {
        String url1 = "how2j.cn";
        String url2 = "http://how2j.cn/k/tmall_springboot/tmall_springboot-1799/1799.html";
        String urla = URLUtil.formatUrl(url1);
        System.out.println("格式化之后:"+urla);

        String urlb = URLUtil.encode(url2);
        System.out.println("编码数据:"+urlb);

        String urlc = URLUtil.decode(urlb);
        System.out.println("解码数据:"+urlc);

        String urld = URLUtil.getPath(url2);
        System.out.println("对应路径路径:"+urld);

    }
}
