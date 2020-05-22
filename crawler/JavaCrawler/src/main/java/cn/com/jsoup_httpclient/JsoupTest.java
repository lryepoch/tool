package cn.com.jsoup_httpclient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {

    /**
     * jsoup方式 获取虎扑新闻列表页
     * @param url
     */
    public static void jsoupList(String url){

        try {
            Document document = Jsoup.connect(url).get();
            // 使用 css选择器 提取列表新闻 a 标签
            Elements elements = document.select("div.news-list > ul > li > div.list-hd > h4 > a");
            for (Element element:elements){
                //获取链接
                String d_url= element.attr("href");
                //获取标题
                String title = element.ownText();
                System.out.println(d_url+title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        String url = "https://voice.hupu.com/nba";
        jsoupList(url);

    }

}
