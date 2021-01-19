package org.itstack.demo.design.door.config;

import org.springframework.util.StringUtils;

/**
* 配置服务类
*/
public class StarterService {

    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }

}
