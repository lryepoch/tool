package com.crawler.login;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * 手动设置Cookie
 *
 */
public class LoginTest {
    public static void setCookie(String url) throws IOException {

        Document document = Jsoup.connect(url)
                //手动设置cookies
                .header("Cookie", "bid=6R3w_Htpauo; douban-fav-remind=1; __yadk_uid=UyowaSaKRdTxlB10LGW7QrE2Vg75KldT; trc_cookie_storage=taboola%2520global%253Auser-id%3D7eed416b-2c5a-4fda-923b-d043b888adb4-tuct48a4bd5; ll=\"118298\"; _vwo_uuid_v2=D7D01D3D40EAB96E3C9EA2118DBCFA29C|a9e48027672bed607a34eba7b39344bd; __gads=ID=aeffe2c2f70f3ec7:T=1581260535:S=ALNI_MbYPQpzPmUYVYsDED5zggS0MOZO-A; _pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1582248187%2C%22https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DNmm55f4zM9emI-5pWcXqg3gxBPvyFmt9vfezt8395umjapbEgpaDAqV_5CsjczWL%26wd%3D%26eqid%3Dc212144b0016b856000000065e4f30f7%22%5D; _pk_ses.100001.8cb4=*; __utma=30149280.816449790.1572267733.1581260536.1582248188.15; __utmc=30149280; __utmz=30149280.1582248188.15.11.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; __utmt=1; dbcl2=\"169539269:jVEQcd+zbgc\"; ck=DJ49; ap_v=0,6.0; push_noty_num=0; push_doumail_num=0; __utmv=30149280.16953; Hm_lvt_183ee1e2005c419c9528525cb5ad66f2=1582248193,1582248234; douban-profile-remind=1; _pk_id.100001.8cb4=54ce60de65dc5955.1568905120.16.1582248353.1579174506.; __utmb=30149280.9.10.1582248188; Hm_lpvt_183ee1e2005c419c9528525cb5ad66f2=1582248359")
                .get();

        if (document != null) {
            //获取豆瓣昵称节点
            Element element = document.select(".info h1").first();
            if (element == null) {
                System.out.println("没有找到.info h1标签");
                return;
            }
            String userName = element.ownText();
            System.out.println("豆瓣我的网名为:" + userName);

        } else {
            System.out.println("出错啦！！！");
        }
    }

    public static void main(String[] args) throws IOException {
        setCookie("https://www.douban.com/people/169539269/");
    }

}