package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/15  17:55
 */
public class HJ42学英语 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numstr = new String[]{null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen"};
        String[] teens = new String[]{null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                "ninety"};
        String[] points = new String[]{"", "thousand", "million", "billion"};
        while (sc.hasNext()) {
            String num = sc.nextLine();
            if (num.length() > 9) {
                System.out.println("error");
            }
            StringBuilder sb = new StringBuilder();
            char[] arr = num.toCharArray();
            boolean andflag = true;
            int len = num.length();
            for(int i = (len - 1) / 3; i >= 0; i--){
                int m = len - 1 - i * 3;
                //h：百位, t:十位和个位
                int h = m < 2 ? 0 : (arr[m - 2] - '0');
                int t = (m < 1 ? 0 : ((arr[m - 1] - '0') * 10)) + arr[m] - '0';
                //3位为空继续下次循环
                if(h == 0 && t == 0) {
                    continue;
                }
                if(t == 0 && sb.length() > 0) {
                    sb.append(" and");
                }
                if(h > 0) {
                    sb.append(' ').append(numstr[h]).append(" hundred");
                    if(t > 0){
                        sb.append(" and");
                    }
                }
                if(t > 20) {
                    sb.append(' ').append(teens[t / 10]);
                    if(t % 10 > 0){
                        sb.append(' ').append(numstr[t % 10]);
                    }
                }else if (t > 0) {
                    sb.append(' ').append(numstr[t]);
                }
                sb.append(' ').append(points[i]);
            }
            sb.deleteCharAt(0);
            System.out.println(sb.toString());
        }
    }
}
