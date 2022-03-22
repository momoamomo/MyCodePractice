package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/2/18  17:40
 */
public class HJ55挑7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
