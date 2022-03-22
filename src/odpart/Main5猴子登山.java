package odpart;
 /*
         一天一只顽猴想要从山脚爬到山顶
          途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
          试问？猴子通过这个阶梯有多少种不同的跳跃方式

          输入描述：
            输入只有一个这个数n    0<n<50
            此阶梯有多个台阶
          输出描述：
            有多少种跳跃方式

          实例:
           输入
             50
           输出
              122106097

           输入
              3
           输出
              2
         */

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/28  12:14
 */
public class Main5猴子登山 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            dp[1]=1;
            dp[2]=1;
            dp[3]=2;
            for (int i = 4; i <=n ; i++) {
                dp[i]=dp[i-1]+dp[i-3];
            }
        System.out.println(dp[n]);
        }

    }
}
