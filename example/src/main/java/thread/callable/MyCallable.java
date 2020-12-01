package thread.callable;

import java.util.concurrent.Callable;

/**
 * @author lryepoch
 * @date 2020/11/27 14:18
 * @description TODO 实现Callable接口，这是有返回值的多线程操作
 */
public class MyCallable implements Callable<Integer> {
    //初始变量
    int x = 2;
    int y = 3;

    //构造方法
    public MyCallable() {

    }

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x + y;
    }


}
