package nowcoderHW.part1;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author sunzhilin
 * @date 2020/8/15  15:14
 */
public class HJ3明明的随机数 {
    public static void main(String[] args) {
        //TreeSet是基于TreeMap实现的
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            TreeSet<Integer> set = new TreeSet<Integer>();
            int num = in.nextInt();
            while (num>0){
                set.add(in.nextInt());
                num--;
            }
            for (Integer i: set) {
                System.out.println(i);
            }
        }
    }
}
