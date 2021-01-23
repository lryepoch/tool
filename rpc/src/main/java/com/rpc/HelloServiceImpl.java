package com.rpc;

/**
 * @author lryepoch
 * @date 2021/1/23 15:10
 * @description TODO 服务提供者接口实现
 */
public class HelloServiceImpl implements HelloService {
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
