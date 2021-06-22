package com.base.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author lryepoch
 * @date 2019-12-18 2019/12/18
 * @description
 */
@Data
public class Person {
    @JSONField(name = "Name")
    private String name;
    @JSONField(name = "AGE")
    private String age;
/*    @JSONField(format = "yyyy-MM-dd")
    private Date com.base.time;*/

}