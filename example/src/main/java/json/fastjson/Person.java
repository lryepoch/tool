package json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import java.util.Date;

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
    private Date time;*/

}