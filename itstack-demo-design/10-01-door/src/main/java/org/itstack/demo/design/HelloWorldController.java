package org.itstack.demo.design;

import org.itstack.demo.design.domain.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
* 在这里白名单的代码占据了一大块，但它又不是业务中的逻辑，而是因为我们上线过程中需要做的开量前测试验证。
*/
public class HelloWorldController {

    public UserInfo queryUserInfo(@RequestParam String userId) {

        // 做白名单拦截
        List<String> userList = new ArrayList<String>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("ccc");
        if (!userList.contains(userId)) {
            return new UserInfo("1111", "非白名单可访问用户拦截！");
        }

        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }

}
