package com.pattern.flyweight;

import java.util.Hashtable;

//享元工厂角色类
public class FlyweightFactory {

    //一个用来存所有享元对象的集合String表示对象的键的类型 ->内蕴状态；Flyweight表示对象值的类型
    private Hashtable<String, Flyweight> flyweight = new Hashtable<>();

    public Flyweight getFlyweight(String obj) {
        //先从缓存中查找对象
        Flyweight fly = flyweight.get(obj);

        if (fly == null) {
            // 如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyweight(obj);
            // 把这个新的Flyweight对象添加到缓存中
            flyweight.put(obj, fly);
        }
        return fly;
    }

    //得到存对象的集合的长度
    public int getFlyweightSize() {
        return flyweight.size();
    }

}
