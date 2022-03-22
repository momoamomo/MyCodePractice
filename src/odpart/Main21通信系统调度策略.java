package odpart;
/*
        在通信系统中有一个常见的问题是对用户进行不同策略的调度
        会得到不同系统消耗的性能
        假设由N个待串行用户，每个用户可以使用A/B/C三种不同的调度策略
        不同的策略会消耗不同的系统资源
        请你根据如下规则进行用户调度
        并返回总的消耗资源数
        规则是：相邻的用户不能使用相同的调度策略
        例如：
        第一个用户使用A策略 则第二个用户只能使用B和C策略
        对单的用户而言，不同的调度策略对系统资源的消耗可以规划后抽象为数值
        例如
        某用户分别使用ABC策略的系统消耗，分别为15 8 17
        每个用户依次选择当前所能选择的对系统资源消耗最少的策略,局部最优
        如果有多个满足要求的策略，选最后一个

        输入描述：
            第一行表示用户个数N
            接下来表示每一行表示一个用户分别使用三个策略的资源消耗
            resA resB resC

        输出描述：
            最优策略组合下的总的系统消耗资源数

         示例一：
          输入：
              3
              15 8 17
              12 20 9
              11 7 5
          输出：
              24
           说明:
            1号用户使用B策略
            2号用户使用C策略
            3号用户使用B策略
           系统资源消耗8+9+7

     */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  22:33
 */
public class Main21通信系统调度策略 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<TreeMap<Integer, Integer>> set = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> group =
                    Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            //从后往前
            for (int j = 2; j >= 0; j--) {
                map.put(group.get(j), j);
            }
            set.add(map);
        }

        //记录每个所使用策略的资源数和位置
        int[][] flags = new int[n][2];

        //获取第一个用户的最小值及位置（treeMap排在第一位的即为最小值）
        Integer firstMinValue = new ArrayList<>(set.get(0).keySet()).get(0);
        flags[0][0] = firstMinValue;
        flags[0][1] = set.get(0).get(firstMinValue);

        //后面的用户
        for (int i = 1; i < n; i++) {
            Integer minValue = new ArrayList<>(set.get(i).keySet()).get(0);
            int pos = set.get(i).get(minValue);
            //相邻的用户选择同一种策略，
            if (pos == flags[i - 1][1]) {
                minValue = new ArrayList<>(set.get(i).keySet()).get(1);
                flags[i][0] = minValue;
                flags[i][1] = set.get(i).get(minValue);
            } else {
                flags[i][0] = minValue;
                flags[i][1] = pos;
            }
        }
        //输出结果
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += flags[i][0];
        }
        System.out.println(sum);
    }
}
