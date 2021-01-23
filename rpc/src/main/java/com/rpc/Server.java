package com.rpc;

import java.io.IOException;

/**
 * @author lryepoch
 * @date 2021/1/23 15:11
 * @description TODO 注册中心接口
 */
public interface Server {
    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
