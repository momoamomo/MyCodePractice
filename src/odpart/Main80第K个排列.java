package odpart;
/*
        给定参数n,从1到n会有n个整数:1,2,3,...,n,
        这n个数字共有n!种排列.
      按大小顺序升序列出所有排列的情况,并一一标记,
      当n=3时,所有排列如下:
      "123" "132" "213" "231" "312" "321"
      给定n和k,返回第k个排列.

      输入描述:
        输入两行，第一行为n，第二行为k，
        给定n的范围是[1,9],给定k的范围是[1,n!]。
      输出描述：
        输出排在第k位置的数字。

      实例1：
        输入:
          3
          3
        输出：
          231
        说明
          3的排列有123,132,213...,那么第三位置就是213

      实例2：
        输入
          2
          2
        输出：
          21
        说明
          2的排列有12,21，那么第二位置的为21
   */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/27  17:16
 */
public class Main80第K个排列 {
    //同 leetCode 第60题

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        sc.close();
        StringBuilder sb = new StringBuilder();
        List<Integer> candidates = new ArrayList<>();
        int[] factorials = new int[n+1];
        //0的阶乘为1
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
            factorials[i] = factorials[i - 1] * i;
        }
        k-=1;
        //思路：从头到尾一位一位的确定
        //n位数，以1开头的个数为（n-1）的阶乘
        for (int i = n-1; i >=0 ; i--) {
            int index = k/factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }
        System.out.println(sb);
    }
}
