package com.base.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * @author lryepoch
 * @date 2019-12-03 2019/12/3
 * @description
 */
public class JSONObjectTest {
    public static void main(String[] args) {
        //新建JSONObject对象
        JSONObject object1 = new JSONObject();

        //1.在JSONObject对象中放入键值对
        object1.put("name", "张三");
        object1.put("name1", "张三1");
        object1.put("name2", "张三2");
        System.out.println("2-----------------");

        //2.根据key获取value
        String name = (String) object1.get("name");
        System.out.println("根据key获取value:"+name);
        System.out.println("3--------------------");

        //3.获取JSONObject中的键值对个数
        int size = object1.size();
        System.out.println("获取JSONObject中的键值对个数:"+size);
        System.out.println("4----------------------");

        //4.判断是否为空
        boolean result = object1.isEmpty();
        System.out.println("判断是否为空:"+result);
        System.out.println("5---------------------");

        //5.是否包含对应的key值，包含返回true，不包含返回false
        boolean isContainsKeyResult = object1.containsKey("name");
        System.out.println("是否包含对应的key值，包含返回true，不包含返回false:"+isContainsKeyResult);
        System.out.println("6----------------------");

        //6.是否包含对应的value值，包含返回true，不包含返回false
        boolean isContainsValueResult = object1.containsValue("王五");
        System.out.println("是否包含对应的value值，包含返回true，不包含返回false:"+isContainsValueResult);
        System.out.println("7----------------------");

        //7.JSONObjct对象中的value是一个JSONObject对象，即根据key获取对应的JSONObject对象；
        JSONObject object2 = new JSONObject();
        System.out.println(object2);
        //将jsonobject对象作为value进行设置
        object2.put("student1", object1);
        JSONObject student =object2.getJSONObject("student1");
        System.out.println(student);
        System.out.println("8------------------------");

        //8.如果JSONObject对象中的value是一个JSONObject数组，既根据key获取对应的JSONObject数组；
        JSONObject objectArray = new JSONObject();
        //创建JSONArray数组
        JSONArray jsonArray = new JSONArray();
        //在JSONArray数组设值:jsonArray.add(int index, Object value);
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1, "another jsonArray value");
        objectArray.put("testArray", jsonArray);

        JSONObject objectArray2 = new JSONObject();
        objectArray2.put("test",objectArray);
        System.out.println("对象中的对象："+objectArray2);

        //获取JSONObject对象中的JSONArray数组
        JSONArray jsonArray2 = objectArray.getJSONArray("testArray");
        System.out.println(objectArray);
        System.out.println(jsonArray2);
        System.out.println("9--------------------------");

        //9.remove.根据key移除JSONObject对象中的某个键值对
        object1.remove("name");
        System.out.println("删除后，剩余：" + object1);
        System.out.println("10----------------------");

        //10.取得JSONObject对象中key的集合
        Set<String> keySet= object1.keySet();
        for (String key : keySet) {
            System.out.println("取得JSONObject对象中key的集合:"+key);
        }
        System.out.println("11------------------");

        //11.取得JSONObject对象中的键和值的映射关系
        Set<Map.Entry<String, Object>> entrySet = object1.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            System.out.println("取得JSONObject对象中的键和值的映射关系:"+entry);
        }
        System.out.println("12------------------");

        //12.转换为json字符串
        String str1 = object1.toJSONString();
        System.out.println("转换为json字符串:"+str1);
        String str2 =object1.toString();
        System.out.println("转换为json字符串:"+str2);
    }
}