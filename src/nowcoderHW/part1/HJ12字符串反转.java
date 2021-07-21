package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/23  15:23
 */
public class HJ12字符串反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new StringBuilder(str).reverse().toString());
    }
}
