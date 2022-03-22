package odpart;
/*
  输入一串字符串
  字符串长度不超过100
  查找字符串中相同字符连续出现的最大次数

  输入描述
    输入只有一行，包含一个长度不超过100的字符串

  输出描述
    输出只有一行，输出相同字符串连续出现的最大次数

   说明：
     输出

   示例1：
     输入
       hello
     输出
       2

    示例2：
      输入
       word
      输出
       1

     示例3：
      输入
        aaabbc
       输出
        3

    字符串区分大小写
   */

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/28  10:04
 */
public class Main75最大连续字符 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        char[] ss = str.toCharArray();
        if(ss.length==1){
            System.out.println(1);
        }else {
            int max = 0;
            int temp = 0;
            for (int i = 0; i < ss.length; i+=temp ) {
                for (int j = i+1; j < ss.length; j++) {
                    if(ss[i]!=ss[j]){
                        temp = j-i;
                        max = Math.max(temp,max);
                        break;
                    }
                }
            }
            System.out.println(max);
        }
    }

}
