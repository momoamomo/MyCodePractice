package testLocal;

/*
近年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N）,排一排，。一个月后有m颗胡杨未能成活。
可补种胡杨K颗，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？

输入：
N总种植数量
M 未成活胡杨数量
M个空格分割的数，按编号从小到大排列
K 最多可以补种的数量
其中：
1<=N<=100000
1<=M<=N
0<=K<=M
输出：
最多的连续胡杨棵数

例1：
5
2
2 4
1
输出：
3

例2：
输入：
10
3
2 4 7
1
输出：
6
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  14:52
 */
public class OD2022021801 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer N = Integer.parseInt(sc.nextLine());
        Integer M = Integer.parseInt(sc.nextLine());
        int[] a = new int[N];
        for (int i = 0; i < M; i++) {
            int idx = sc.nextInt();
            a[idx - 1] = 1;
        }
        int k = sc.nextInt();
        sc.close();
        dfs(a, 0, k, 0);
        System.out.println(res);

    }

    public static void dfs(int[] a, int idx, int k, int sum) {
        if (idx == a.length || k <= 0) {
            if (k == 0) {
                res = Math.max(res, getRes(a));
            }
        }
        for (int i = idx; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            //每找到一个未成活的胡杨，补种，修改标记，可补种数量-1
            a[i] = 0;
            dfs(a, idx + 1, k - 1, sum + 1);
            a[i] = 1;
        }
    }

    //获取数组中最长连续活着的胡杨林
    public static int getRes(int[] a) {
        int sum = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                sum++;
            } else {
                max = Math.max(sum, max);
                sum = 0;
            }
        }
        return max;
    }
}
