package nowcoderHW.part1;


//功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
// 最后一个数后面也要有空格

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/15  21:46
 */
public class HJ6质数因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        for (int i=2;i<=num;){
            if(num%i==0){
                System.out.print(i+" ");
                num /=i;
            }else {
                i++;
            }
        }
    }
}
