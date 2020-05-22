package cn.com.login;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟登录豆瓣 访问个人中心 这种方式可防止cookie过期
 * 先构造登录请求参数，成功后获取到cookies
 * 设置request cookies，再次请求
 *
 */
public class Login2Test {
    public static void jsoupLogin(String loginUrl, String userInfoUrl) throws IOException {
        //构造登陆参数
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "13415824288");
        data.put("password", "liran19960826");
        data.put("remember", "false");
        data.put("ticket", "");
        data.put("ck", "");
        Connection.Response login = Jsoup.connect(loginUrl)
                .ignoreContentType(true)//忽略类型验证
                .followRedirects(false)//禁止重定向
                .postDataCharset("utf-8")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Accept", "application/json")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .data(data)
                .method(Connection.Method.POST)
                .execute();
        login.charset("UTF-8");
        //login中已经获取到登录成功之后的cookies
        //构造访问个人中心的请求
        Document document = Jsoup.connect(userInfoUrl)
                .cookies(login.cookies())
                .get();
        if (document != null) {
            Element element = document.select(".info h1").first();
            if (element == null) {
                System.out.println("没有找到.info h1 标签");
                return;
            }
            String userName = element.ownText();
            System.out.println("豆瓣名:" + userName);
        } else {
            System.out.println("出错！");
        }
    }
    public static void main(String[] args) throws IOException {
        //个人中心
        String user_info_url = "https://www.douban.com/people/169539269/";
        //登陆接口
        String login_url = "https://accounts.douban.com/j/mobile/login/basic";
        jsoupLogin(login_url,user_info_url);
    }
}
