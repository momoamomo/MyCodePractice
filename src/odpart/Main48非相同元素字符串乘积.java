package odpart;

 /*
        给定一个元素类型为小写字符串的数组
        请计算两个没有相同字符的元素长度乘积的最大值
        如果没有符合条件的两个元素返回0

        输入描述
          输入为一个半角逗号分割的小写字符串数组
          2<= 数组长度 <=100
          0< 字符串长度 <=50
        输出描述
          两个没有相同字符的元素长度乘积的最大值

        示例一
          输入
            iwdvpbn,hk,iuop,iikd,kadgpf
          输出
            14
          说明
           数组中有5个元组  第一个和第二个元素没有相同字符
           满足条件 输出7*2=14

         */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/2/11  22:39
 */
public class Main48非相同元素字符串乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lists = sc.nextLine().split(",");
        int max = 0;
        for (int i = 0; i < lists.length - 1; i++) {
            for (int j = i + 1; j < lists.length; j++) {
                //依次遍历后一个字符串的每个字符
                char[] chars = lists[j].toCharArray();
                int k = 0;
                while (k < chars.length) {
                    //不等于-1说明有个字符，退出
                    if (lists[i].indexOf(chars[k]) != -1) {
                        break;
                    }
                    k++;
                }
                int tmp = lists[i].length() * lists[j].length();
                //这个判断才能说明两个串没有重叠元素
                if (k == chars.length) {
                    max = Math.max(tmp, max);
                }
            }
        }
        System.out.println(max);
    }


    //备注：判断两个字符串是否包含相同的字符，
    // 思路：转换为字符列表，两个列表合为一个列表，并去重，去重后的长度小于之前的两者之和说明有重复
    public boolean isConflict(String s1, String s2) {
        List<String> set1 = new ArrayList<>();
        Collections.addAll(set1, s1.split(""));
        List<String> set2 = new ArrayList<>();
        Collections.addAll(set2, s1.split(""));
        List<String> set = new ArrayList<>();
        set.addAll(set1);
        set.addAll(set2);
        int last = set.stream().distinct().collect(Collectors.toList()).size();
        return last < set1.size() + set2.size();

    }
}
