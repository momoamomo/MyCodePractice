package nowcoderHW.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/15  16:06
 */
public class HJ5进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        while (sc.hasNext()){
            String str = sc.nextLine();
            if (!"0x".equals(str.substring(0, 2))) {
                System.out.println("非十六进制数！");
            }
            StringBuffer sb = new StringBuffer(str.substring(2));
            String ns = new StringBuilder(sb).reverse().toString();
            int len = ns.length();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int num;
                char cr = ns.charAt(i);
                if (Character.isDigit(cr)) {
                    num = (int) cr - (int) ('0');
                } else {
                    num = map.get(cr);
                }
                sum += num * Math.pow(16, i);
            }
            System.out.println(sum);
        }
    }
}
