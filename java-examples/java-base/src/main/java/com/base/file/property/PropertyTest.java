package com.base.file.property;

import java.io.IOException;
import java.util.Properties;

/**
 * @author lryepoch
 * @date 2021/1/23 14:39
 * @description TODO 测试props.load(new FileInputStream("db.properties"));
 */
public class PropertyTest {
    public static void main(String[] args) {

    }

    public void readProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(PropertyTest.class.getClass().getResourceAsStream("/data.properties"));
        String server = (String) properties.get("bootstrap.servers");
        String id = (String) properties.get("group.id");
        System.out.println(server + " " + id);
    }
}
