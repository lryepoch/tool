package com.fanout;

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * @author lryepoch
 * @date 2020/5/22 18:03
 * @description TODO
 */
public class RabbitMQUtil {
    public static void main(String[] args) {
        checkServer();
    }
    public static void checkServer(){
        System.out.println(NetUtil.isUsableLocalPort(15672));
        if (NetUtil.isUsableLocalPort(15672)){
            JOptionPane.showMessageDialog(null,"RabbitMQ服务器未启动");
            System.exit(1);
        }
        System.out.println("RabbitMQ服务器已启动");
    }
}
