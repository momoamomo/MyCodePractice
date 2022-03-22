package odpart;
/*
        同一个数轴x有两个点的集合A={A1,A2,...,Am}和B={B1,B2,...,Bm}
        A(i)和B(j)均为正整数
        A、B已经按照从小到大排好序，AB均不为空
        给定一个距离R 正整数，列出同时满足如下条件的
        (A(i),B(j))数对
        1. A(i)<=B(j)
        2. A(i),B(j)之间距离小于等于R
        3. 在满足1，2的情况下每个A(i)只需输出距离最近的B(j)
        4. 输出结果按A(i)从小到大排序

        输入描述
        第一行三个正整数m n R
        第二行m个正整数 表示集合A
        第三行n个正整数 表示集合B

        输入限制 1<=R<=100000
        1<=n,m<=100000
        1<= A(i),B(j) <= 1000000000

        输出描述
        每组数对输出一行 A(i)和B(j)
        以空格隔开

        示例一
        输入
        4 5 5
        1 5 5 10
        1 3 8 8 20

        输出
        1 1
        5 8
        5 8

         */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  13:57
 */
public class Main35数轴点集合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> AList = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> BList = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer a : AList) {
            for (Integer b : BList) {
                if (a <= b && (b - a <= nums.get(2))) {
                    System.out.println(a + " " + b);
                    break;
                }
            }
        }

    }
}
