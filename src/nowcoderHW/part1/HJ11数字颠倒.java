package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/23  15:17
 */
public class HJ11数字颠倒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        String ss = String.valueOf(num);
//        System.out.println(ss);
        String newStr = new StringBuilder(ss).reverse().toString();
        System.out.println(newStr);
    }
}
