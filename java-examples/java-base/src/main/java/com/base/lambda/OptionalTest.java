package com.base.lambda;

import java.util.List;
import java.util.Optional;

/**
 * @author lryepoch
 * @date 2020/11/3 11:07
 * @description TODO
 */
public class OptionalTest {
    public static void main(String[] args) {

        //1.ofNullable
        Optional name= Optional.ofNullable("javaHuang");
        System.out.println(name);
        System.out.println(name.isPresent());
        System.out.println(name.get());

        Optional emptyValue = Optional.ofNullable(null);//""
        System.out.println(emptyValue);
        System.out.println(emptyValue.isPresent());
//        System.out.println(emptyValue.get());//java.util.NoSuchElementException: No value present

        Optional<List<Object>> stringList = Optional.ofNullable(null);
        System.out.println(stringList.get().size());

        System.out.println("----------------------");


        //2.of
        Optional<String> optional = Optional.of("javaHuang");
        System.out.println(optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        //传入参数为null，抛出NullPointerException.
//        Optional<String> nullValue= Optional.of(null);
//        System.out.println(nullValue);
//        System.out.println(nullValue.isPresent());
//        System.out.println(nullValue.get());

        System.out.println("-------------------------");


    }
}
