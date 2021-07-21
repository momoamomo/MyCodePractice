package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/5/3  10:38
 */
public class HJ73计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ss = sc.nextLine();
            String[] time = ss.split(" ");
            int year = Integer.parseInt(time[0]);
            int month = Integer.parseInt(time[1]);
            int day = Integer.parseInt(time[2]);
            int count = 0;
            boolean isRN = false;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                isRN = true;
            } else {
                isRN = false;
            }
            int[] dayNum1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int[] dayNum2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if(isRN){
                for (int i = 0; i < month-1; i++) {
                    count = count+dayNum2[i];
                }
            }else {
                for (int i = 0; i < month-1; i++) {
                    count = count+dayNum1[i];
                }
            }
            count = count + Integer.parseInt(time[2]);
            System.out.println(count);
        }
    }

}
