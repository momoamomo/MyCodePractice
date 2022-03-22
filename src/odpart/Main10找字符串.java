package odpart;
/*
        给定两个字符串
        从字符串2中找出字符串1中的所有字符
        去重并按照ASCII码值从小到大排列
        输入字符串1长度不超过1024
        字符串2长度不超过100

        字符范围满足ASCII编码要求，按照ASCII由小到大排序

        输入描述：
         bach
         bbaaccddfg
         输出
          abc

          2
          输入
          fach
          bbaaccedfg
          输出
          acf

         */

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/28  23:00
 */
public class Main10找字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split("");
        String str2 = sc.nextLine();
        HashSet<String> set = new HashSet();
        for (int i = 0; i < str1.length; i++) {
            if (str2.contains(str1[i])){
             set.add(str1[i]);
            }
        }
        for(String item: set){
            System.out.print(item);
        }

    }
}
