package testLocal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  14:57
 */
public class OD2022021803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        sc.close();

        //处理
        int count = 0;
        int[] a = new int[gr.length];
        int[] b = new int[gr[0].length];
        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[0].length; j++) {
                if (gr[i][j] == 1) {
                    a[i]++;
                    b[j]++;
                }
            }
        }
        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[0].length; j++) {
                if (gr[i][j] == 1) {
                    if (a[i] > 1 || b[j] > 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
