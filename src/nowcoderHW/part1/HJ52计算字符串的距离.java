package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/7/20  17:12
 */
public class HJ52计算字符串的距离 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            //动态规划
            int dp[][] = new int[str1.length() + 1][str2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];

                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                    }
                }
            }
            System.out.println(dp[str1.length()][str2.length()]);
        }
    }
}
