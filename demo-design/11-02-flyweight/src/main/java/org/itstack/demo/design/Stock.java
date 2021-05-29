package org.itstack.demo.design;

/**
 * @author lryepoch
 * @date 2021/1/12 13:50
 * @description 库存信息
 */
public class Stock {

    private int total; // 库存总量
    private int used;  // 库存已用

    public Stock(int total, int used) {
        this.total = total;
        this.used = used;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}
