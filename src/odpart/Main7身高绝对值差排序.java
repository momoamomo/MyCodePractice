package odpart;
 /*
         小明今年升学到了小学1年纪
         来到新班级后，发现其他小朋友身高参差不齐
         然后就想基于各小朋友和自己的身高差，对他们进行排序
         请帮他实现排序
         输入描述
          第一行为正整数 h和n
          0<h<200 为小明的身高
          0<n<50 为新班级其他小朋友个数
          第二行为n各正整数
           h1 ~ hn分别是其他小朋友的身高
         取值范围0<hi<200
         且n个正整数各不相同

         输出描述
          输出排序结果，各正整数以空格分割
          和小明身高差绝对值最小的小朋友排在前面
          和小明身高差绝对值最大的小朋友排在后面
          如果两个小朋友和小明身高差一样
          则个子较小的小朋友排在前面

          示例一
          输入
          100 10
          95 96 97 98 99 101 102 103 104 105
          输出
           99 101 98 102 97 103 96 104 95 105

          说明  小明身高100
          班级学生10个  身高分别为
         */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/1/28  22:23
 */
public class Main7身高绝对值差排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()).get(0);
//        int n = sc.nextInt();
        List<Integer> list = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //排序
        List<Integer> sortList = list.stream().sorted(((o1, o2) -> {
            int d1 = Math.abs(o1 - h);
            int d2 = Math.abs(o2 - h);
            if (d1 == d2) {
                return o1 - o2;
            } else {
                return d1 - d2;
            }

        })).collect(Collectors.toList());

        //输出
        StringBuilder sb = new StringBuilder();
        for (Integer item : sortList) {
            sb.append(item).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
