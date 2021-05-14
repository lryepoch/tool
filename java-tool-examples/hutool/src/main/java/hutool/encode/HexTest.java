package hutool.encode;

import cn.hutool.core.util.HexUtil;
import hutool.constant.Comment;
import org.junit.Test;

import java.awt.*;

/**
 * @author lryepoch
 * @date 2020/5/21 15:22
 * @description TODO
 */
public class HexTest {

    @Test
    @Comment("判断是不是十六进制")
    public void test1() {
        String s1 = "12";
        boolean b1 = HexUtil.isHexNumber(s1);
        System.out.println(b1);
        String s2 = "0x12";
        boolean b2 = HexUtil.isHexNumber(s2);
        System.out.println(b2);
    }

    @Test
    @Comment("字符串和十六进制互相转换")
    public void test2(){
        String s1 = "how2j.cn - java ";
        String s2 = HexUtil.encodeHexStr(s1);
        String s3 = HexUtil.decodeHexStr(s2);
        System.out.println(s2+"{ }"+s3);
    }

    @Test
    @Comment("颜色转换")
    public void test3() {
        Color color1 = Color.red;
        System.out.println(color1);

        String s1 = HexUtil.encodeColor(color1);
        System.out.println(s1);

        String s2 = "#112233";
        Color color2 = HexUtil.decodeColor(s2);
        System.out.println(color2);
    }
}