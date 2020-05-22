package json.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lryepoch
 * @date 2019-12-18 2019/12/18
 * @description
 */
public class FastjsonTest {
    private Person person;

    @Before
    public void setUp(){
        person = new Person();
        person.setName("xxx");
        person.setAge("20");
    }

    @Test
    public void test(){
        String jsonStr = JSONObject.toJSONString(person);
        System.out.println("bean to json:" + jsonStr);

        person = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Person.class);
        System.out.println("json to bean:" + person.getName());
    }
}