package nowcoderHW.part1;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/15  14:55
 */
public class HJ2计算字符个数 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = (char)System.in.read();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.toUpperCase(c)==Character.toUpperCase(str.charAt(i))){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
