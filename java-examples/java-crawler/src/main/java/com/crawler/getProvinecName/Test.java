package com.crawler.getProvinecName;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取全国的每个省的城市以及对应的区域代码
 * 输入到一个字典（json）
 */
public class Test {
    /**
     * @description 解析省份
     */
    public static void parseProvinceName(Map<String, Map<String, String>> map, String url) throws IOException {
        /**
         * 获取页面文档数据
         */
        Document doc = Jsoup.connect(url).get();

        /**
         * 获取页面上所有的tbody标签
         */
        Elements elements = doc.getElementsByTag("tbody");
        /**
         * 拿到第五个tbody标签
         */
        Element element = elements.get(4);

        /**
         * 拿到第五个tbody标签下所有的子标签
         */
        Elements childrens = element.children();

        /**
         * 当前页面的URL
         */
        String baseUri = element.baseUri();

        for (Element element1 : childrens) {
            Elements provincetrs = element1.getElementsByClass("provincetr");
            for (Element provincetr : provincetrs) {
                Elements tds = provincetr.getElementsByTag("td");
                for (Element td : tds) {
                    String provinceName = td.getElementsByTag("a").text();
                    String href = td.getElementsByTag("a").attr("href");

                    System.out.println(provinceName + "  " + baseUri + href);

                    map.put(provinceName, null);
                    /**
                     * 组装城市页面的URL，进入城市页面爬城市名称
                     */
                    parseCityName(map, baseUri + href, provinceName);
                }
            }
        }
    }

    public static void parseCityName(Map<String, Map<String, String>> map, String url, String provinceName) throws IOException {

        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.getElementsByTag("tbody");

        Element element = elements.get(4);

        Elements childrens = element.children();

//        String baseUri = element.baseUri();

        Map<String, String> cityMap = new HashMap<String, String>();

        for (Element element1 : childrens) {
            Elements citytrs = element1.getElementsByClass("citytr");

            for (Element cityTag : citytrs) {
                Elements tds = cityTag.getElementsByTag("td");
                /**
                 * 直辖市，城市名就是本身
                 */
                String cityName = tds.get(1).getElementsByTag("a").text();
                if (cityName.equals("市辖区")) {
                    cityName = provinceName;
                }

//                String href1 = tds.get(1).getElementsByTag("a").attr("href");
                String href2 = tds.get(0).getElementsByTag("a").text();

                System.out.println(cityName + " " + href2);

                cityMap.put(cityName, href2);
            }
        }
        map.put(provinceName, cityMap);
    }

    public static void main(String[] args) throws IOException {
        Map<String, Map<String,String>> map = new HashMap<String, Map<String, String>>();
        parseProvinceName(map, "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/");
//        System.out.println(map);
        System.out.println(JSON.toJSONString(map));
    }
}
