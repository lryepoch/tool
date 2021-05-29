package org.itstack.demo.design.lang;

/**
* Collection，集合方法部分用于对自定义的数据结构添加通用方法；add、remove、iterator等核心方法
*/
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L l);

    boolean removeLink(String key);

    Iterator<E> iterator();

}
