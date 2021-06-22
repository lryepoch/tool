package com.base.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DefaultHttpClientTest {

    /**
     * 模拟get请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String doGet(String url) throws IOException {
        DefaultHttpClient httpClient= new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String body="{}";
        body = EntityUtils.toString(entity);
        return body;
    }

    /**
     * 模拟post请求
     * @param url
     * @param name_value_pair
     * @return
     * @throws IOException
     */
    public static String doPost(String url, List<NameValuePair> name_value_pair) throws IOException{
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(name_value_pair, StandardCharsets.UTF_8));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String body = "{}";
        body = EntityUtils.toString(entity);
        return body;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(doGet("http://data.cma.cn/"));
    }
}
