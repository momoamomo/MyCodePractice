package nowcoderHW.part1;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunzhilin
 * @date 2020/8/23  15:31
 */
public class HJ13句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        List<String> list = Stream.of(sentence.split(" ")).collect(Collectors.toList());
        Collections.reverse(list);
        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}
