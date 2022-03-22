package odpart;
//        给定两个整数数组
//array1 array2  数组元素按升序排列
// 假设从arr1 arr2中分别取出一个元素，可构成一对元素
// 现在需要取出k对元素，并对取出的所有元素求和
// 计算和的最小值
// 注意：两对元素对应arr1 arr2的下标是相同的
//       视为同一对元素

//输入描述
//    输入两行数组arr1 arr2
//    每行首个数字为数组大小size   0<size<=100
//    arr1，2中的每个元素   0< <1000
//    接下来一行  正整数k   0<k<=arr1.size * arr2.size
// 输出描述
//   满足要求的最小值

// 例子

//输入
//   3 1 1 2
//   3 1 2 3
//   2

//输出
//   4

//说明：用例中需要取两个元素，
// 取第一个数组第0个元素与第二个数组第0个元素组成一个元素
// [1,1]
//取第一个数组第1个元素与第二个数组第0个元素组成一个元素
// [1,1]

//求和为1+1+1+1=4 ,满足要求最小

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/1/28  16:58
 */
public class Main2元素对求和 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //思路：先把所有的可能对之和找出，排序后再求总和
        int[] arr1 = getArray(sc.nextLine());
        int[] arr2 = getArray(sc.nextLine());
        int k = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i: arr1) {
            for (int j : arr2) {
                list.add(i + j);
            }
        }
        int sum = 0;
        List<Integer> sortlist = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            sum += sortlist.get(i);
        }
        System.out.println(sum);


    }
    private static int[] getArray(String line){
        String[] data = line.split("\\s+");
        int[] arr = new int[Integer.parseInt(data[0])];
        for (int i = 0; i < data.length-1; i++) {
            arr[i]=Integer.parseInt(data[i+1]);
        }
        return arr;
    }
}
