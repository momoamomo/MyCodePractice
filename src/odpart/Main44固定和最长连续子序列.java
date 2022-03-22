package odpart;
/*
         有N个正整数组成的一个序列
         给定一个整数sum
         求长度最长的的连续子序列使他们的和等于sum
         返回次子序列的长度
         如果没有满足要求的序列 返回-1
         案例1：
         输入
         1,2,3,4,2
         6
         输出
         3
         解析：1,2,3和4,2两个序列均能满足要求
         所以最长的连续序列为1,2,3 因此结果为3

         示例2：
         输入
         1,2,3,4,2
         20
         输出
         -1
         解释：没有满足要求的子序列，返回-1

         备注： 输入序列仅由数字和英文逗号构成
         数字之间采用英文逗号分割
         序列长度   1<=N<=200
         输入序列不考虑异常情况
         由题目保证输入序列满足要求
          */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/12  12:52
 */
public class Main44固定和最长连续子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Stream.of(sc.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = sc.nextInt();
        sc.close();

        int maxlen = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temSum = 0;
            int sublen = 0;
            for (int j = i; j < nums.size(); j++) {
                if (temSum > sum) {
                    break;
                }
                temSum += nums.get(j);
                sublen++;
                if (temSum == sum) {
                    maxlen = Math.max(sublen, maxlen);
                }
            }
        }
        maxlen = maxlen == 0 ? -1 : maxlen;
        System.out.println(maxlen);
    }
}
