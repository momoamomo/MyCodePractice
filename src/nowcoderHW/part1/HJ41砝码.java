package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/15  16:38
 */
public class HJ41砝码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 1 || n > 10) {
                System.out.println("请输入[1-10]之间的数");
            }
            int[] m = new int[n];
            int[] x = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
                if (n < 1 || n > 2000) {
                    System.out.println("砝码重量范围[1-2000]");
                }
                x[i] = sc.nextInt();
                if (n < 1 || n > 6) {
                    System.out.println("同一砝码数量范围[1-6]");
                }
                sum += m[i] * x[i];
            }
            System.out.println(fama(n, m, x, sum));
        }
    }

    private static int fama(int n, int[] m, int[] x, int sum) {
        //能得到的重量用标志位标记
        boolean[] flag = new boolean[sum + 1];
        flag[0] = true;
        flag[1] = true;
        int top = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x[i]; j++) {
                for (int k = top+m[i]; k >= m[i]; k--) {
                    if(flag[k-m[i]]){
                        flag[k] = true;
                    }

                }
                top =+ m[i];
            }
        }
        int count = 0;
        for(boolean f: flag){
            if(f){
                count++;
            }
        }
        return count;

    }
}
