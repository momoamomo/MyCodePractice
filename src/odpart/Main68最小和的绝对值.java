package odpart;
/*
给定一个随机的整数数组(可能存在正整数和负整数)nums,
请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
并返回这两个数(按从小到大返回)以及绝对值。
每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

输入描述：
 一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
 且整数数值范围是[-65535,65535]

输出描述：
  两个数和两数之和绝对值

 示例一：
  输入
  -1 -3 7 5 11 15
  输出
  -3 5 2

说明：
因为|nums[0]+nums[2]|=|-3+5|=2最小，
所以返回-3 5 2

 */

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/5  16:38
 */
public class Main68最小和的绝对值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list =
                Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).distinct().collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        TreeSet<Integer> resSet = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                Integer a = list.get(i);
                Integer b = list.get(j);
                int sum = Math.abs(a + b);
                if (sum < min && !a.equals(b) ) {
                    min = sum;
                    resSet.clear();
                    resSet.add(a);
                    resSet.add(b);
                }
            }
        }
        if (resSet.size() != 0) {
            for (Integer aa : resSet) {
                System.out.print(aa + " ");
            }
            System.out.println(min);
        }
    }
}
