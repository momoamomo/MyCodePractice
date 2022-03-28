package testLocal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
在一个机房中，服务器的位置标识在一个n*m的整数矩阵网络中，1表示单元格上有服务器，0表示没有。
如果两台服务器位于统一行或者同一列中紧邻的位置，则认为他们之间可以组成一个局域网。
请你统计机房中最大的局域网包含的服务个数。
输入：
第一行输入两个正整数，n和m,0<n,m<100
之后为n*m的二维数组，代表服务器信息
输出：
最大局域网包含的服务器个数

例：
输入
2 2
1 0
1 1
输出
3

 */

/**
 * @author szl
 * @date 2022/2/22  22:56
 */
public class 最大局域网 {
    public static int sum = 0;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = 0;
        int[][] c = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                c[i][j] = sc.nextInt();
            }
        }

        //我的输入写法，太繁琐
        /*Scanner sc = new Scanner(System.in);
        List<Integer> ss = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int n = ss.get(0);
        int m = ss.get(1);
        int[][] gr = new int[n][m];
        for (int i = 0; i < n; i++) {
            List<Integer> ips = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < m; j++) {
                gr[i][j] = ips.get(j);
            }
        }
        sc.close();*/

        //处理
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (c[i][j] == 1) {
                    huisu(c, i, j);
                    //可能存在多个不相连的局域网，取最大
                    res = Math.max(sum, res);
                    sum = 0;
                }
            }
        }
        System.out.println(res);
    }

    public static void huisu(int[][] c, int a, int b) {
        //超出矩阵边界位置不统计
        //注：递归统计，如果相邻位置不再有服务器 不统计 c[a][b] != 1
        if (a < 0 || a >= c.length || b < 0 || b >= c[0].length || c[a][b] != 1) {
            return;
        }
        //做标记，已经统计过的判断过位置设为2，在外部循环中不再判断
        //当前位置由服务器，数量+1
        c[a][b] = 2;
        sum++;
        //判断相邻位置
        huisu(c, a - 1, b);
        huisu(c, a, b - 1);
        huisu(c, a + 1, b);
        huisu(c, a, b + 1);
    }
}
