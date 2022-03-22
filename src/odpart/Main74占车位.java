package odpart;
/*
    特定大小的停车场 数组cars表示
    其中1表示有车  0表示没车
    车辆大小不一，小车占一个车位(长度1)
    货车占两个车位(长度2)
    卡车占三个车位(长度3)
    统计停车场最少可以停多少辆车
    返回具体的数目

    输入描述：
      整型字符串数组cars
      其中1表示有车0表示没车
      数组长度<1000

    输出描述：
      整型数字字符串
      表示最少停车数

    示例1：
      输入
        1,0,1
      输出
        2
      说明：
        一个小车占第一个车位
        第二个车位空，一个小车占第三个车位
        最少有两辆车

     示例2:
       输入：
         1,1,0,0,1,1,1,0,1
       输出：
         3
       说明：
         一个货车占第1,2个车位
         第3,4个车位空
         一个卡车占第5,6,7个车位
         第8个车位空
         一个小车占第9个车位
         最少3俩个车
     */

import java.util.Scanner;

/**
 * @author szl
 * @date 2022/1/28  10:43
 */
public class Main74占车位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //先去掉逗号，再分隔出非0连续串
        String ss = sc.nextLine().replaceAll(",","");
        //todo:正则分隔 多个0
        String[] list = ss.split("[0]+");
        int num = 0;
        for (String item : list) {
            int len = item.length();
            while (len>3){
                num++;
                len -=3;
            }
            //当连续的位置，小于等于3时，最少都是一辆车
            if(len>0){
                num++;
            }
        }
        System.out.println(num);
    }
}
