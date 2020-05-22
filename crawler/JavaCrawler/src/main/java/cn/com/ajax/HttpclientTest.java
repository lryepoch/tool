package cn.com.ajax;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 使用反向解析法，解决数据异步交互问题
 */
public class HttpclientTest {
    public static void httpclientMethod(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "GBK");

            body = body.replace("data_callback(", "");
            body = body.substring(0, body.lastIndexOf(")"));

            JSONArray jsonArray = JSON.parseArray(body);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                System.out.println("文章标题：" + data.getString("title") + ",文章链接：" + data.getString("docurl")+"，标签："+data.get("label"));

            }
        } else {
            System.out.println("处理失败！！返回状态码：" + response.getStatusLine().getStatusCode());
        }
    }

    public static void main(String[] args) throws IOException {
        httpclientMethod("https://temp.163.com/special/00804KVA/cm_yaowen.js?callback=data_callback");
    }
}
