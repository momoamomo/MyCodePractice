package odpart;

/*
            给定一个数组
            编写一个函数
            来计算他的最大N个数和最小N个数的和
            需要对数组进行去重

            说明
            第一行输入M
            M表示数组大小
            第二行输入M个数
            表示数组内容
            第三行输入N表示需要计算的最大最小N的个数

            输出描述
            输出最大N个数和最小N个数的和

            例一：
                输入
                5
                95 88 83 64 100
                2

                输出
                342

                说明
                最大2个数[100 95] 最小2个数[83 64]
                输出342

             例二
                输入
                5
                3 2 3 4 2
                2

                输出
                 -1
                 说明
                 最大两个数是[4 3]最小2个数是[3 2]
                 有重叠输出为-1

         */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  16:56
 */
public class Main28最大N个数和最小N个数之和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        List<Integer> nums = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int N = Integer.parseInt(sc.nextLine());
        sc.close();

        List<Integer> list = nums.stream().distinct().sorted().collect(Collectors.toList());
        Integer sum1 = list.subList(0, N).stream().mapToInt(Integer::intValue).sum();
//        Integer sum1 = list.subList(0, N).stream().mapToInt(o->o).sum();
        Integer sum2 = list.subList(list.size() - N, list.size()).stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1 + sum2);
    }
}
