package odpart;

/*
  1.输入字符串s输出s中包含所有整数的最小和，
  说明：1字符串s只包含a~z,A~Z,+,-，
  2.合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
  3.负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
  输入描述：包含数字的字符串
  输出描述：所有整数的最小和
  示例：
    输入：
      bb1234aa
  　输出
      10
  　输入：
      bb12-34aa
  　输出：
      -31
  说明：1+2-(34)=-31
   */

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/27  15:43
 */
public class Main82最小和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        char[] chars = str.toCharArray();
        int sum = 0;
        //最小和：正数按一位相加，负数按相连的最大数处理
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c =='-'){
                i++;
                int start = i;
                while (i<chars.length && Character.isDigit(chars[i])){
                    i++;
                }
                String sub = str.substring(start,i);
                if(sub.length()>0){
                    sum -= Integer.parseInt(sub);
                }
                i--;
                continue;
            }
            //正数依次相加
            if(Character.isDigit(c)){
                sum+=Character.digit(c,10);
            }
        }
        System.out.println(sum);
    }
}
