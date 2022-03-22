package interview;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/3/4  15:39
 */
public class HR1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list1 = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Integer n = nums.get(0);
        Integer m = nums.get(1);
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.contains(list1.get(i))) {
                count++;
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (!list1.contains(list2.get(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
