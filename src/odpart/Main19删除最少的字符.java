package odpart;
 /*
    删除字符串中出现次数最少的字符
    如果多个字符出现次数一样则都删除

    例子：
    输入
      abcdd
      字符串中只
     输出
      dd

    输入
      aabbccdd

    输出
      empty

      如果都被删除  则换为empty

     */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/14  15:36
 */
public class Main19删除最少的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        List<String> list = Stream.of(ss.split("")).collect(Collectors.toList());
        //stream分组统计
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));

//        Long[] counts = new Long[map.values().size()];
//        Long[] longs = map.values().toArray(counts);
//        Arrays.sort(longs);
//        Long min = longs[0];

        List<Long> sortValues = map.values().stream().sorted().collect(Collectors.toList());
        Long min = sortValues.get(0);
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue().equals(min)) {
                ss = ss.replaceAll(entry.getKey(), "");
            }
        }
        System.out.println(ss.length() == 0 ? "empty" : ss);
    }
}
