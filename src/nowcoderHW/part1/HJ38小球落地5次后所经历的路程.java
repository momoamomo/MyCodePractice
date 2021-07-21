package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/14  17:35
 */
public class HJ38小球落地5次后所经历的路程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            double high = sc.nextDouble();
            double l = high;
            double ls = high;
            for (int i = 1; i <=4 ; i++) {
                double s = ls/2;
                l += 2*s;
                ls = s;
            }
            System.out.println(l);
            System.out.println(high/32);

        }
    }
}
