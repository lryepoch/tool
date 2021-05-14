package com.crawler.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * selenium解决数据异步加载问题
 *
 */
public class SeleniumTest {

    public static void selenium(String url) {
        System.getProperties().setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(url);
        //获取要闻列表
        List<WebElement> webElements = webDriver.findElements(By.xpath("//div[@class='news_title']/h3/a"));
        System.out.println(webElements);
        for (WebElement webElement : webElements){
            //提取新闻链接
            String article_url = webElement.getAttribute("href");
            //提取新闻标题
            String title = webElement.getText();
            if (article_url.contains("http://news.163.com/")){
                System.out.println("文章标题："+title+",文章链接"+article_url);
            }
        }
        webDriver.close();
    }

    public static void main(String[] args) {
        selenium("https://news.163.com/");
    }
}
