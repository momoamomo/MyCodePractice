package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/14  19:12
 */
public class HJ40统计字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int en = 0;
            int blank = 0;
            int num = 0;
            int other = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)){
                    en++;
                }else if(ch==' '){
                    blank++;
                }else if (ch>=48&&ch<=57){
                    num++;
                }else {
                    other++;
                }
            }
            System.out.println(en);
            System.out.println(blank);
            System.out.println(num);
            System.out.println(other);
        }
    }
}
