package nowcoderHW.part1;

import java.util.Scanner;

/**
 * 描述
 * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
 * 本题输入含有多组数据
 * 输入描述：
 * 1.输入待截取的字符串
 * 2.输入一个正整数k，代表截取的长度
 *
 * 输出描述：截取后的字符串
 *
 * 示例1
 * 输入：
 * abABCcDEF
 * 6
 * 输出：
 * abABCc
 * 复制
 * 示例2
 * 输入：
 * ffIKEHauv
 * 1
 * bdxPKBhih
 * 6
 * 复制
 * 输出：
 * f
 * bdxPKB
 */

/**
 * @author sunzhilin
 * @date 2021/7/20  10:17
 */
public class HJ46按字节截取字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int len = Integer.parseInt(sc.nextLine());
            System.out.println(str.substring(0,len));
        }
    }
}
