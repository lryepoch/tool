package org.itstack.demo.design.lang;

/**
* Iterable，提供获取迭代器，这个接口类会被Collection继承
*/
public interface Iterable<E> {

    Iterator<E> iterator();

}
