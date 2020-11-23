package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * @author lryepoch
 * @date 2020/6/29 18:24
 * @description TODO HttpClient发送邮件
 */
public class EmailHttpClientTest {

    public static Boolean sendEmailWithFile(Email email) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://10.2.8.136:19002/sendEmailC");
        HttpEntity entity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addTextBody("sender", "")
                .addTextBody("password", "")
                .addTextBody("head", "")
                .addTextBody("key", "")
                .addTextBody("rc", "")
                .addTextBody("cc", "")
                .addTextBody("content", email.getContent(), ContentType.create("text/plain", Charset.forName("UTF-8"))).build();
        post.setEntity(entity);
        HttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == 200) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return response.getStatusLine().getStatusCode() == 200;
        } else {
            throw new Exception();
        }

    }
}
