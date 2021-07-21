package testLocal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/5/3  11:23
 */
public class H1Test2021050301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] number = num.split(",");
            int m = Integer.parseInt(number[0]);
            if (m < 3 || m > 10) {
                System.out.println("-1");
                break;
            }
            int n = Integer.parseInt(number[1]);
            if (n < 3 || n > 100) {
                System.out.println("-1");
                break;
            }
            int[] cans = new int[n];
            int[][] hh = new int[m][n];
            for (int i = 0; i < m; i++) {
                String allScore = sc.nextLine();
                String[] score = allScore.split(",");
                for (int j = 0; j <= score.length - 1; j++) {
                    cans[j] += Integer.parseInt(score[j]);
                    hh[i][j] = Integer.parseInt(score[j]);
                }
            }

            int[] res = new int[3];
            int[] cansCopy = Arrays.copyOf(cans, cans.length);
            int[] cansCopy2 = Arrays.copyOf(cans, cans.length);
            Arrays.sort(cansCopy);
            int k = 0;
            for (int i = cansCopy.length - 1; i >= cansCopy.length - 3; i--) {
                for (int j = 0; j < cans.length; j++) {
                    if (cans[j] == cansCopy[i]) {
//                        System.out.println(j + 1);
                        res[k] = j;
                        k++;
                        cans[j] = 0;
                        break;
                    }
                }
            }

            Integer[] temp1 = new Integer[m];
            Integer[] temp2 = new Integer[m];
            if (cansCopy2[0] == cansCopy2[1]) {
                for (int i = 0; i < m; i++) {
                    temp1[i] = hh[i][res[0]];
                    temp2[i] = hh[i][res[1]];
                }
                Arrays.sort(temp1, Collections.reverseOrder());
                Arrays.sort(temp2,Collections.reverseOrder());
                for (int i = 0; i < m; i++) {
//                    System.out.println("1："+temp1[i]);
//                    System.out.println("2："+temp2[i]);
                    if (temp1[i] < temp2[i]) {
                        int temp = res[0];
                        res[0] = res[1];
                        res[1] = temp;
                        break;
                    }
                }
            }
            if (cansCopy2[1] == cansCopy2[2]) {
                for (int i = 0; i < m; i++) {
                    temp1[i] = hh[i][res[1]];
                    temp2[i] = hh[i][res[2]];
                }
                Arrays.sort(temp1, Collections.reverseOrder());
                Arrays.sort(temp2,Collections.reverseOrder());
                for (int i = 0; i < m; i++) {
                    if (temp1[i] < temp2[i]) {
                        int temp = res[1];
                        res[1] = res[2];
                        res[2] = temp;
                        break;
                    }
                }
            }
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]+1);

            }

        }
    }
}
