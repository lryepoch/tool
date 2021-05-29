package org.itstack.demo.design.test;

import com.beust.jcommander.JCommander;
import org.itstack.demo.design.Cmd;
import org.junit.Assert;

public class ApiTest {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        System.out.println("cmd=" + cmd);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        System.out.printf("classpath:%s class:%s args:%s\n", cmd.classpath, cmd.getMainClass(), cmd.getAppArgs());
    }


}
