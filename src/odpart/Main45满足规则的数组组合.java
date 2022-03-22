package odpart;
/*
    给定一个正整数数组
    检查数组中是否存在满足规则的数组组合
    规则：
      A=B+2C
    输入描述
     第一行输出数组的元素个数
     接下来一行输出所有数组元素  用空格隔开
    输出描述
     如果存在满足要求的数
     在同一行里依次输出 规则里 A/B/C的取值 用空格隔开
     如果不存在输出0

     示例1：
       输入
       4
       2 7 3 0
       输出
       7 3 2
       说明：
        7=3+2*2
       示例2：
       输入
        3
        1 1 1
       输出
        0
        说明找不到满足条件的组合

        备注：
        数组长度在3~100之间
        数组成员为0~65535
        数组成员可以重复
        但每个成员只能在结果算式中使用一次
        如 数组成员为 [0,0,1,5]
        0出现两次允许，但结果0=0+2*0不允许  因为算式中使用了3个0

        用例保证每组数字里最多只有一组符合要求的解
     */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/12  12:33
 */
public class Main45满足规则的数组组合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> list = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        sc.close();
        //A=B+2C
        list = list.stream().sorted().collect(Collectors.toList());

        String res = "0";
        for (int i = list.size()-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k <i ; k++) {
                    Integer A = list.get(i);
                    Integer B = list.get(j);
                    Integer C = list.get(k);
                    if (A == B + 2 * C) {
                        res = A + " " + B + " " + C;
                    }
                }
            }
        }
        System.out.println(res);

    }
}
