package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/14  15:57
 */
public class HJ35蛇形矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= num; i++) {
                int start = (i - 1) * i / 2 + 1;
                int step = i + 1;
                for (int j = 1; j <= num - i + 1; j++) {
                    sb.append(start).append(" ");
                    start += step;
                    step++;
                }
                sb.setCharAt(sb.length()-1,'\n');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
