package odpart;
 /*
        单词接龙的规则是
        可用于接龙的单词首字母必须要与前一个单词的尾字母相同
        当存在多个首字母相同的单词时
        取长度最长的单词
        如果长度也相等则取词典序最小的单词
        已经参与接龙的单词不能重复使用
        现给定一组全部由小写字母组成的单词数组
        并指定其中的一个单词为起始单词
        进行单词接龙
        请输出最长的单词串
        单词串是由单词拼接而成 中间没有空格

        输入描述：
            输入的第一行为一个非负整数
            表示起始单词在数组中的索引k  0<=k<=n
            第二行输入的是一个非负整数表示单词的个数n
            接下来的n行分别表示单词数组中的单词

        输出描述：
            输出一个字符串表示最终拼接的字符串

        示例1：
        输入
          0
          6
          word
          dd
          da
          dc
          dword
          d

        输出
          worddwordda

        说明：
        先确定起始单词word
        再确定d开头长度最长的单词dword
        剩余以d开头且长度最长的由 da dd dc
        则取字典序最小的da
        所以最后输出worddwordda

        示例二：
        输入：
            4
            6
            word
            dd
            da
            dc
            dword
            d
         输出：
         dwordda

     */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author szl
 * @date 2022/2/10  15:33
 */
public class Main55单词接龙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        sc.close();
        String start = list.get(index);
        StringBuilder sb = new StringBuilder(start);
        list.remove(start);
        //所有单词先按长度排序再按自然顺序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        int len;
        do {
            len = sb.length();
            String lastChar = sb.substring(sb.length() - 1);
            for (int i = 0; i < list.size(); i++) {
                String cur = list.get(i);
                if (cur.startsWith(lastChar)) {
                    sb.append(cur);
                    list.remove(cur);
                    break;
                }
            }
        } while (sb.length() != len);

        System.out.println(sb.toString());


    }
}
