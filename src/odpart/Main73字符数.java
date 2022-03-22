package odpart;
/*

    给出一个只包含字母的字符串,
    不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
    并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
    如果次数相同,按照自然顺序排序,且小写字母在大写字母之前

    输入描述:
      输入一行仅包含字母的字符串

    输出描述:
      按照字母出现次数从大到小的顺序输出各个字母和字母次数,
      用英文分号分割,
      注意末尾的分号
      字母和次数中间用英文冒号分隔

    示例:
        输入: xyxyXX
        输出:x:2;y:2;X:2;
    说明:每个字符出现的次数为2 故x排在y之前
    而小写字母x在大写X之前

    示例2:
        输入:
         abababb
        输出:
            b:4;a:3
        说明:b的出现个数比a多 故排在a前
     */

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/1/28  11:00
 */
public class Main73字符数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
//            List<Map.Entry<Character, Integer>> list =
//                    map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList());

            List<Map.Entry<Character, Integer>> list =
                    map.entrySet().stream().sorted((o1, o2) -> {
                        int v1 = o1.getValue();
                        char k1 = o1.getKey();
                        int v2 = o2.getValue();
                        char k2 = o2.getKey();
                        if (v1 != v2) {
                            return v2 - v1;
                        } else {
                            if((Character.isUpperCase(k1) && Character.isUpperCase(k2)) ||((Character.isLowerCase(k1) && Character.isLowerCase(k2)))){
                                return k1 - k2;
                            }else {
                                return k2 - k1;
                            }

                        }
                    }).collect(Collectors.toList());


            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : list) {
                builder.append(entry.getKey()).append(":")
                        .append(entry.getValue()).append(";");
            }

            System.out.print(builder);
        }


    }
}
