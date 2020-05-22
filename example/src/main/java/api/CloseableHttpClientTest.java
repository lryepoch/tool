package api;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class CloseableHttpClientTest {

    /**
     * 模拟get请求 httpclient4.3.4
     *
     */
    public static void requestGet(String urlWithParams) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet(urlWithParams);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(50)
                .setConnectTimeout(50)
                .setSocketTimeout(50).build();
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println("StatusCode->"+response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();
        String jsonStr = EntityUtils.toString(entity,"utf-8");
        System.out.println(jsonStr);

        httpGet.releaseConnection();
    }

    /**
     * 模拟Post请求
     *
     */
    public static void requestPost(String url, List<NameValuePair> params) throws Exception{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.toString());

        HttpEntity entity = response.getEntity();
        String jsonStr = EntityUtils.toString(entity,"utf-8");
        System.out.println(jsonStr);

        httpPost.releaseConnection();
    }

    public static void main(String[] args) {
        String loginUrl = "";
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name","li"));
        params.add(new BasicNameValuePair("password","123"));

        try {
            requestPost(loginUrl,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
