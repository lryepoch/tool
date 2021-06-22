package com.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lryepoch
 * @date 2020/10/21 9:23
 * @description TODO 获取Ip地址
 */
public class GetIpTest {
    public static void main(String[] args) {
        String regex = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
        String content = "{mynet=[NovaAddress{address=192.168.1.5, type=fixed, version=4, macaddr=fa:16:3e:ac:28:6c}]}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
//        if(matcher.find()){
//            for(int i=0; i<=matcher.groupCount(); i++){
//                System.out.println(i+":"+matcher.group(i));
//            }
//        }
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
