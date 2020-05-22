package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 260408
 * @date 2020/1/10 11:22
 * @description 在使用lambda表达式前，是通过哪些传统手段实现业务逻辑的
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> accounts= new ArrayList<>();
        accounts.add("tom");
        accounts.add("rwgyr");
        accounts.add("gere");
        accounts.add("eetre");
        accounts.add("grwrtj");

        //1.1长度大于5的有效账号
//        for (String account : accounts){
//            if (account.length()>=5){
//                System.out.println("有效账号："+account);
//            }
//        }

        //1.2迭代方式进行操作
//        Iterator<String> iterator = accounts.iterator();
//        while (iterator.hasNext()) {
//            String account = iterator.next();
//            if (account.length() >= 5) {
//                System.out.println("it有效账号："+account);
//            }
//        }

        //1.3 stream 结合 lambda表达式，完成业务处理
        List validAccounts = accounts.stream().filter(s -> s.length()>=5).collect(Collectors.toList());
        System.out.println(validAccounts);

        System.out.println(accounts.stream().filter(s -> s.length()<5).collect(Collectors.toList()));
    }
}