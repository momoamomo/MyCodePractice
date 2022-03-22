package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/3/4  16:17
 */
public class HW2 {
    public static void main(String[] args) {
        String[] strArray = {"1", "2", "3", "4", "5", "6"};
        List<Integer> list = Arrays.stream(strArray).map(Integer::parseInt).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        final String s = "invalid";
        final String c = ":";
        //23:59:59
        //第一位不能大于3,获取数组中小于3的数字中最大的一个
        int data1 = getDataOfLocation(list, 3);
        if (data1 != -1) {
            list.remove(Integer.valueOf(data1));
            result.append(data1);
        } else {
            System.out.println(s);
        }
        //第一位是2
        if (result.charAt(0) == '2') {
            //第二位
            int data2 = getDataOfLocation(list, 4);
            if (data2 != -1) {
                // 按照元素删除
                list.remove(Integer.valueOf(data2));
                result.append(data2);
                result.append(c);
            } else {
                System.out.println(s);
            }
        } else {
            // 否则,第一位是0或者1,第二位可以是0-9
            int data3 = getDataOfLocation(list, 10);
            if (data3 != -1) {
                list.remove(data3);
                result.append(data3);
                result.append(c);
            } else {
                System.out.println(s);
            }
        }
        //第3位 最大59:59
        int data4 = getDataOfLocation(list, 6);
        if (data4 != -1) {
            list.remove(Integer.valueOf(data4));
            result.append(data4);
        } else {
            System.out.println(s);
        }
        //第4位
        int data5 = getDataOfLocation(list, 10);
        if (data5 != -1) {
            list.remove(Integer.valueOf(data5));
            result.append(data5);
            result.append(c);
        } else {
            System.out.println(s);
        }
        //第五位
        int data6 = getDataOfLocation(list, 6);
        if (data6 != -1) {
            list.remove(Integer.valueOf(data6));
            result.append(data6);
        } else {
            System.out.println(s);
        }
        //最后一位
        if (getDataOfLocation(list, 10) != -1) {
            result.append(getDataOfLocation(list, 10));
        } else {
            System.out.println(s);
        }
        System.out.println(result.toString());

    }
    //获取数组中比 standard 小的数字中最大的一个数,没有返回-1
    static int getDataOfLocation(List<Integer> list, int standard) {
        return list.stream().filter(x -> x < standard).mapToInt(x -> x).max().orElse(-1);
    }
}
