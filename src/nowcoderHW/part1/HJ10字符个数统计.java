package nowcoderHW.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author sunzhilin
 * @date 2020/8/23  15:03
 */
public class HJ10字符个数统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> list = new ArrayList<Character>();
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            list.add(ch);
        }
        List newlist = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newlist.size());
    }
}
