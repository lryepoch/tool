package lambda;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 260408
 * @date 2020/1/10 14:54
 * @description TODO 各种数据类型和Stream之间的转换
 */
public class Test3 {
    public static void main(String[] args) {
        //1.批量数据->stream对象
        //多个数据
        Stream stream1 = Stream.of("admin", "tom", "damu");

        //数组
        String[] strArrays = new String[]{"xueqi", "biyao"};
        Stream stream2 = Arrays.stream(strArrays);

        //列表
        List<String> list = new ArrayList<>();
        list.add("少林");
        list.add("武当");
        list.add("青城");
        list.add("崆峒");
        list.add("峨眉");
        Stream stream3 = list.stream();

        //集合
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("武当长拳");
        Stream stream4 = set.stream();

        //Map
        Map<String, Integer> map = new HashMap<>();
        map.put("tom", 1000);
        map.put("jerry", 1231);
        Stream stream5 = map.entrySet().stream();


        //2.Stream对象对于基本数据类型的功能封装
        //int/long/double
//        IntStream.of(new int[]{10,20,30}).forEach(System.out::println);
//        IntStream.range(1,5).forEach(System.out::println);
//        IntStream.rangeClosed(1,5).forEach(System.out::println);

        //3.Stream对象-->转换得到指定的数据类型
        //数组
//        Object [] objx = stream1.toArray(String[]::new);
//        System.out.println(objx[2]);

        //字符串
//        String str = stream1.collect(Collectors.joining()).toString();
//        System.out.println(str);

        //列表
//        List<String> list1 = (List<String>) stream1.collect(Collectors.toList());
//        System.out.println(list1);

        //集合
//        Set<String> setx = (Set<String>) stream1.collect(Collectors.toSet());
//        System.out.println(setx);

        //Map
//        Map<String,String> mapx = (Map<String,String>) stream1.collect(Collectors.toMap(x->x,y->"value:"+y));
//        System.out.println(mapx);

        //4.Stream中常见的API操作
        List<String> accountsList = new ArrayList<>();
        accountsList.add("tom");
        accountsList.add("rwgyr");
        accountsList.add("gere");
        accountsList.add("eetre");
        accountsList.add("grwrtj");


        //map()中间操作，map()方法接收一个Functional接口
//        accountsList = accountsList.stream().map(x->"哈哈哈:"+x).collect(Collectors.toList());
//        accountsList.forEach(System.out::println);
//        System.out.println(accountsList);

        //filter()添加过滤条件，过滤符合条件的用户
//        accountsList = accountsList.stream().filter(x-> x.length() > 5).collect(Collectors.toList());
//        accountsList.forEach(System.out::println);

        //forEach()增强型循环
//        accountsList.forEach(x -> System.out.println("forEach->" + x));
//        accountsList.forEach(x -> System.out.println("forEach->" + x));
//        accountsList.forEach(x -> System.out.println("forEach->" + x));

//        //peek()中间操作，迭代数据完成数据的一次处理过程
//        accountsList.stream()
//                .peek(x -> System.out.println("peek 1:" + x))
//                .peek(x -> System.out.println("peek 2:" + x))
//                .forEach(System.out::println);

        //Stream中对于数字运算的支持
        List<Integer> integerList = new ArrayList<>();
        integerList.add(20);
        integerList.add(19);
        integerList.add(7);
        integerList.add(8);
        integerList.add(86);
        integerList.add(52);
        integerList.add(20);


        //skip()中间操作，有状态，跳过部分数据
//        integerList.stream().skip(3).forEach(System.out::println);

        //limit()中间操作，有状态，限制输出数据量
//        integerList.stream().skip(3).limit(2).forEach(System.out::println);

        //distinct()中间操作，有状态，剔除重复的数据
//        integerList.stream().distinct().forEach(System.out::println);

        //sorted()中间操作，有状态，排序

        //max()获取最大值
//        Optional optional = integerList.stream().max((x, y) -> x - y);
//        System.out.println(optional.get());

        //min()获取最小值
//        Optional optional1 = integerList.stream().min((x, y) -> x - y);
//        System.out.println(optional1.get());

        //reduce()合并处理数据
        Optional optional2 = integerList.stream().reduce((sum, x) -> sum + x);
        System.out.println(optional2.get());

    }

}
