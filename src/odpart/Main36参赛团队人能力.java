package odpart;
/*
        用数组代表每个人的能力
        一个比赛活动要求 参赛团队的最低能力值为N
        每个团队可以由一人或者两人组成
        且一个人只能参加一个团队
        计算出最多可以派出多少只符合要求的队伍

        输入描述
        5
        3 1 5 7 9
        8
        第一行代表总人数，范围  1~500000
        第二行数组代表每个人的能力
           数组大小范围 1~500000
           元素取值范围 1~500000
        第三行数值为团队要求的最低能力值
         1~500000

         输出描述
         3
         最多可以派出的团队数量

         示例一
         输入
         5
         3 1 5 7 9
         8

         输出
         3

         说明 3、5组成一队   1、7一队  9自己一队  输出3

         7
         3 1 5 7 9 2 6
         8

        3
        1 1 9
        8

          */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/12  16:45
 */
public class Main36参赛团队人能力 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> powers = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int goal = sc.nextInt();
        sc.close();
        List<Integer> list = powers.stream().sorted().filter(e -> e < goal).collect(Collectors.toList());
        int result = powers.size() - list.size();

        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) >= goal) {
                result++;
                i++;
                j--;
            } else {
                i++;
            }
        }
        System.out.println(result);

    }
}
