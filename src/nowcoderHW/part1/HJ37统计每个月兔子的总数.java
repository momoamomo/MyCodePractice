package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/14  17:21
 */
public class HJ37统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            int a = 1;
            int b = 1;
            int c = 1;
            //b本来有的，c新生的
            for (int i = 2; i < month; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
