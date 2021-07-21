package nowcoderHW.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/16  20:39
 */
public class HJ9提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while (num>0){
            int n = num%10;
            if(!list.contains(n)){
                list.add(n);
                sum=sum*10+n;
            }
            num=num/10;
        }
        System.out.println(sum);
    }
}
