package com.base.base;

/**
 * @author lryepoch
 * @date 2021/6/21 15:33
 * @description TODO 子类通过普通方法调用父类私有成员属性的值
 */
public class JuXing {
    public static void main(String[] args) {
        JuXing1 a = new JuXing1(12, 10);
        Volumn b = new Volumn(12, 10, 5);
        System.out.println(a.getArea());
        System.out.println(b.getVolumn());
    }
}

class JuXing1 {
    private double length;
    private double width;

    public JuXing1(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

class Volumn extends JuXing1 {
    private double height;

    public Volumn(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public double getVolumn() {
        return super.getArea() * height;
    }
}