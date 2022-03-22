package nowcoderHW.part1;
/*
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001

组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。

数据范围：保证输入的是合法的 IP 序列

输入：
10.0.3.193
167969729
复制
输出：
167773121
10.3.3.193
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/22  15:14
 */
public class HJ33整数与ip地址间的转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ips = sc.nextLine();
            Integer num = sc.nextInt();
            List<String> list1 = Stream.of(ips.split(".")).collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (String ip : list1) {
                if ("0".equals(ip)) {
                    sb.append("00000000");
                } else {
                    String ss = Integer.toBinaryString(Integer.valueOf(ip));
                    sb.append(ss);
                }
            }
            //字符串转为十进制数
            Integer resNum = sb.toString().equals("0") ? 0 : Integer.valueOf(sb.toString(), 2);
            System.out.println(resNum);

            //十进制数转为2进制字符串
            String ipstr = Integer.toBinaryString(num);
            System.out.println(ipstr);
            StringBuilder resip = new StringBuilder();
            List<Integer> list2 = new ArrayList<>();
            while (ipstr.length() >= 8) {
                Integer ip = Integer.valueOf(ipstr.substring(0, 8), 2);
                list2.add(ip);
                resip.append(ip).append(".");
            }
            System.out.println(resip.substring(0, resip.length() - 1));


        }
    }

}
