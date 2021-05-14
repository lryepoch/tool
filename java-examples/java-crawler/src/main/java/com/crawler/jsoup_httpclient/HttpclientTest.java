package com.crawler.jsoup_httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * httpclient + 正则表达式方式，获取虎扑新闻列表页
 */
public class HttpclientTest {

    public static void httpClientList(String url) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity, "utf-8");

                /*
                 * 替换掉换行符、制表符、回车符，去掉这些符号，正则表示写起来更简单一些
                 * 只有空格符号和其他正常字体
                 */
                if (body != null) {
                    Pattern pattern = Pattern.compile("\t|\r|\n");
                    Matcher m = pattern.matcher(body);
                    body = m.replaceAll("");
                    System.out.println(body);

                    Pattern pattern1 = Pattern.compile("<div class=\"list-hd\">\\s* <h4>\\s* <a href=\"(.*?)\"\\s* target=\"_blank\">(.*?)</a>\\s* </h4>\\s* </div>");
                    Matcher matcher1 = pattern1.matcher(body);
                    while (matcher1.find()) {
                        System.out.println(matcher1.group(1) + matcher1.group(2));
                    }

                } else {
                    System.out.println("处理失败！！获取正文内容为空");
                }
            } else {
                System.out.println("处理失败！！返回状态码：" + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String url = "https://voice.hupu.com/nba";
        httpClientList(url);
    }
}
