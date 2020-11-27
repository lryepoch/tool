package http;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lryepoch
 * @date 2020/11/23 11:41
 * @description TODO 传统情况下在java代码里访问restful服务，一般使用Apache的HttpClient。不过此种方法使用起来太过繁琐。
 * spring提供了一种简单便捷的模板类来进行操作，这就是RestTemplate。
 */
public class RestTemplateTest {

    private JSONObject getContent() {
        String url = "http://10.2.2.2:8089/batch";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> map = new HashMap<>();
        map.put("", "");
        HttpEntity requestBody = new HttpEntity(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestBody, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;

        /*-----------------------------*/
        //请求地址
//        String url = "http://localhost:8080/testPost";
//        //入参
//        RequestBean requestBean = new RequestBean();
//        requestBean.setTest1("1");
//        requestBean.setTest2("2");
//        requestBean.setTest3("3");
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseBean responseBean = restTemplate.postForObject(url, requestBean, ResponseBean.class);


        /*----------------------------*/
/*
        String rootUrl = "";
        //1.简单Get请求
        String result = restTemplate.getForObject(rootUrl + "get1?para=my", String.class);
        System.out.println("简单Get请求:" + result);

        //2.简单带路径变量参数Get请求
        result = restTemplate.getForObject(rootUrl + "get2/{1}", String.class, 239);
        System.out.println("简单带路径变量参数Get请求:" + result);

        //3.返回对象Get请求（注意需包含compile group: 'com.google.code.gson', name: 'gson', version: '2.8.5'）
        ResponseEntity<GetIpTest> responseEntity1 = restTemplate.getForEntity(rootUrl + "get3/339", GetIpTest.class);
        System.out.println("返回:" + responseEntity1);
        System.out.println("返回对象Get请求:" + responseEntity1.getBody());

        //4.设置header的Get请求
        HttpHeaders headers1 = new HttpHeaders();
        headers1.add("token", "123");
        ResponseEntity<String> response = restTemplate.exchange(rootUrl + "get4", HttpMethod.GET, new HttpEntity<String>(headers1), String.class);
        System.out.println("设置header的Get请求:" + response.getBody());


        //5. Post对象
        GetIpTest test1 = new GetIpTest();
        test1.name = "buter";
        test1.sex = 1;
        result = restTemplate.postForObject(rootUrl + "post1", test1, String.class);
        System.out.println("Post对象:" + result);

        //6.带header的Post数据请求
        response = restTemplate.postForEntity(rootUrl + "post2", new HttpEntity<GetIpTest>(test1, headers), String.class);
        System.out.println("带header的Post数据请求:" + response.getBody());

        //7.带header的Put数据请求
        //无返回值
        restTemplate.put(rootUrl + "put1", new HttpEntity<GetIpTest>(test1, headers));
        //带返回值
        response = restTemplate.exchange(rootUrl + "put1", HttpMethod.PUT, new HttpEntity<GetIpTest>(test1, headers), String.class);
        System.out.println("带header的Put数据请求:" + response.getBody());

        //8.del请求
        //无返回值
        restTemplate.delete(rootUrl + "del1/{1}", 332);
        //带返回值
        response = restTemplate.exchange(rootUrl + "del1/332", HttpMethod.DELETE, null, String.class);
        System.out.println("del数据请求:" + response.getBody());

*/

    }
}
