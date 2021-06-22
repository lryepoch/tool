package com.crawler.login;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class Login3Test {
    public static void httpClientLogin(String loginUrl, String userInfoUrl) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI(loginUrl))
                .setHeader("Upgrade-Insecure-Requests","1")
                .setHeader("Accept","application/com.base.json")
                .setHeader("Content-Type","application/x-www-form-urlencoded")
                .setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .addParameter("name","13415824288")
                .addParameter("password","liran19960826")
                .addParameter("remember","false")
                .addParameter("ticket","")
                .addParameter("ck","")
                .build();
        //模拟登陆
        CloseableHttpResponse response = httpClient.execute(login);
        if (response.getStatusLine().getStatusCode()==200){
            //构造访问个人中心请求
            HttpGet httpGet = new HttpGet(userInfoUrl);
            CloseableHttpResponse user_response = httpClient.execute(httpGet);
            HttpEntity entity = user_response.getEntity();
            System.out.println(entity);

            String body = EntityUtils.toString(entity,"utf-8");
            System.out.println(body);

            System.out.println(body.contains("四季看台"));
        } else {
            System.out.println("模拟登录失败!!");
        }
    }
    public static void main(String[] args) throws Exception {
        //个人中心
        String user_info_url = "https://www.douban.com/people/169539269/";
        //登陆接口
        String login_url = "https://accounts.douban.com/j/mobile/login/basic";
        httpClientLogin(login_url, user_info_url);
    }
}
