package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/15  14:50
 */
public class HJ1字符串最后一个单词的长度 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.isEmpty()||s==null){
            System.out.print(0);
        }
        String[] str = s.split(" ");
        if(str.length==0){
            System.out.print(0);
        }
        System.out.print(str[str.length-1].length());
    }
}
