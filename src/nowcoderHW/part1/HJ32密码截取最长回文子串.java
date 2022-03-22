package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/2/21  18:00
 */
public class HJ32密码截取最长回文子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str == null) {
                System.out.println(0);
            }
            int len = str.length();
            int maxStart = 0, maxEnd = 0;
            int maxLen = 1;
            //dp[j][i]表示从j到i的字符串是否为回文字符串
            boolean[][] dp = new boolean[len][len];
            //i为右边界，j为左边界
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (str.charAt(j) == str.charAt(i) && ((i - j <= 2) || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        if (i - j + 1 > maxLen) {
                            maxLen = i - j + 1;
                            maxStart = j;
                            maxEnd = i;
                        }
                    }
                }
            }
            System.out.println(maxLen);

        }
    }
}
