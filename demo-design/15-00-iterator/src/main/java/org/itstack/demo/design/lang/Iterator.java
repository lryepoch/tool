package org.itstack.demo.design.lang;

/**
* Iterator，提供了两个方法的定义；hasNext、next，会在具体的数据结构中写实现方式
*/
public interface Iterator<E> {

    boolean hasNext();

    E next();
    
}
