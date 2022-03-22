package odpart;
/*
    给定一个字符串
    只包含大写字母
    求在包含同一字母的子串中
    长度第K长的子串
    相同字母只取最长的子串

    输入
     第一行 一个子串 1<len<=100
     只包含大写字母
     第二行为k的值

     输出
     输出连续出现次数第k多的字母的次数

     例子：
     输入
             AABAAA
             2
     输出
             1
       同一字母连续出现最多的A 3次
       第二多2次  但A出现连续3次

    输入

    AAAAHHHBBCDHHHH
    3

    输出
    2

//如果子串中只包含同一字母的子串数小于k

则输出-1

 */

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/2/9  22:45
 */
public class Main57第K长连续子串数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        int k = sc.nextInt();

        char[] chars = ss.toCharArray();
        if (chars.length < k) {
            System.out.println("-1");
            return;
        }

        //把每个连续的字母的最长连续数存入map,先把第一个字母存入，从第2个开始判断于前面是否一样
        HashMap<Character, Integer> map = new HashMap<>();
        char cur = chars[0];
        int count = 1;
        map.put(cur, count);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == cur) {
                count++;
            } else {
                cur = c;
                count = 1;
            }
            map.put(cur, map.containsKey(cur) ? map.get(cur) > count ? map.get(cur) : count : count);

        }
        List<Integer> values = map.values().stream().sorted().collect(Collectors.toList());
        if (values.size() < k) {
            System.out.println("-1");
            return;
        }
        System.out.println(values.get(values.size() - k));
    }
}
