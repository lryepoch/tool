package com.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 这里实现的简单RPC框架是使用Java语言开发，与Java语言高度耦合，并且通信方式采用的Socket是基于BIO实现的，IO效率不高，还有Java原生的序列化机制占内存太多，运行效率也不高。
 * 可以考虑从下面几种方法改进。
 * <p>
 * 可以采用基于JSON数据传输的RPC框架；
 * 可以使用NIO或直接使用Netty替代BIO实现；
 * 使用开源的序列化机制，如Hadoop Avro与Google protobuf等；
 * 服务注册可以使用Zookeeper进行管理，能够让应用更加稳定。
 */
public class RPCTest {
    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
