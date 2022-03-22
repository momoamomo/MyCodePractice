package odpart;
 /*
        幼儿园两个班的小朋友排队时混在了一起
        每个小朋友都知道自己跟前面一个小朋友是不是同班
        请你帮忙把同班的小朋友找出来
        小朋友的编号为整数
        与前面一个小朋友同班用Y表示
        不同班用N表示
        输入描述：
        输入为空格分开的小朋友编号和是否同班标志
        比如 6/N 2/Y 3/N 4/Y
        表示一共有4位小朋友
        2和6是同班 3和2不同班 4和3同班
        小朋友总数不超过999
         0< 每个小朋友编号 <999
         不考虑输入格式错误

         输出两行
         每一行记录一班小朋友的编号  编号用空格分开
         并且
         1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行
         2. 如果只有一个班的小朋友 第二行为空
         3. 如果输入不符合要求输出字符串ERROR

         示例：
         输入
         1/N 2/Y 3/N 4/Y
         输出
         1 2
         3 4
         说明：2的同班标记为Y因此和1同班
              3的同班标记位N因此和1,2不同班
              4的同班标记位Y因此和3同班
         */

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/12  15:32
 */
public class Main40幼儿园小朋友分班 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> friends = Stream.of(sc.nextLine().split(" ")).collect(Collectors.toList());
        List<Integer> class1 = new ArrayList<>();
        List<Integer> class2 = new ArrayList<>();
        char[] chars = new char[friends.size()];
        for (int i = 0; i < friends.size(); i++) {
            String ss = friends.get(i);
            int index = ss.indexOf("/");
            int no = Integer.parseInt(ss.substring(0, index));
            if (no <= 0 || no >= 999) {
                System.out.println("ERROR");
                return;
            }
            String choose = ss.substring(index + 1);
            if (!choose.equals("Y") && !choose.equals("N")) {
                System.out.println("ERROR");
                return;
            }
            if (i == 0) {
                class1.add(no);
                chars[i] = 1;
            } else {
                if (choose.equals("Y")) {
                    if (chars[i - 1] == 1) {
                        class1.add(no);
                        chars[i] = 1;
                    } else {
                        class2.add(no);
                        chars[i] = 2;
                    }
                } else {
                    if (chars[i - 1] == 1) {
                        class2.add(no);
                        chars[i] = 2;
                    } else {
                        class1.add(no);
                        chars[i] = 1;
                    }
                }

            }

        }
        List<String> ss1 = class1.stream().sorted().map(String::valueOf).collect(Collectors.toList());
        List<String> ss2 = class2.stream().sorted().map(String::valueOf).collect(Collectors.toList());
        System.out.println(StringUtils.join(ss1, " "));
        System.out.println(StringUtils.join(ss2, " "));

    }
}
