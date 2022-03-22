package nowcoderHW.part1;

/*
* 描述
输入两个用字符串 str 表示的整数，求它们所表示的数之和。

本题含有多组样例输入。

数据范围： 1 \le len(str) \le 10000 \1≤len(str)≤10000
输入描述：
输入两个字符串。保证字符串只含有'0'~'9'字符

输出描述：
输出求和后的结果
*/

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/2/21  17:28
 */
public class HJ57高精度整数加法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder result = new StringBuilder();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int m = str1.length() - 1;
            int n = str2.length() - 1;
            int carry = 0;
            while (m >= 0 || n >= 0) {
                char c1 = m >= 0 ? str1.charAt(m--) : '0';
                char c2 = n >= 0 ? str2.charAt(n--) : '0';
                int sum = (c1-'0') + (c2-'0') + carry;
                carry = sum / 10;
                result.append(sum % 10);
            }
            if (carry != 0) {
                result.append(carry);
            }
            System.out.println(result.reverse().toString());
        }
    }

}
