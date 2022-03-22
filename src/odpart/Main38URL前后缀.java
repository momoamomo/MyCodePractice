package odpart;
 /*
        给定一个url前缀和url后缀
        通过,分割 需要将其连接为一个完整的url
        如果前缀结尾和后缀开头都没有/
        需要自动补上/连接符
        如果前缀结尾和后缀开头都为/
        需要自动去重
        约束：
         不用考虑前后缀URL不合法情况

         输入描述
         url前缀(一个长度小于100的字符串)
         url后缀(一个长度小于100的字符串)
         输出描述
         拼接后的url

         一、
         输入
         /acm,/bb
         输出
         /acm/bb

         二、
         输入
         /abc/,/bcd
         输出
         /abc/bcd

         三、
         输入
         /acd,bef
         输出
         /acd/bef

         四、
         输入
         ,
         输出
         /

         */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/12  16:34
 */
public class Main38URL前后缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = Stream.of(sc.nextLine().split(",")).collect(Collectors.toList());
        sc.close();

        if (list.size() == 0) {
            System.out.println("/");
            return;
        }

        String result = (list.get(0) + "/" + list.get(1)).replaceAll("/+", "/");
        System.out.println(result);

    }
}
