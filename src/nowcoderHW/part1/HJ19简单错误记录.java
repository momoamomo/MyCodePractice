package nowcoderHW.part1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/9/24  16:29
 */
public class HJ19简单错误记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>(8);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int index = str.indexOf(" ");
            String url = str.substring(0, index);
            String number = str.substring(index + 1);
            int lastIndex = url.lastIndexOf("/");
            String file = url.substring(lastIndex + 1);
            if (file.length() > 16) {
                file = file.substring(file.length() - 16);
            }
            if (map.containsKey(file)) {
                map.put(file, map.get(file) + 1);
            } else {
                map.put(file, number);
            }
        }
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if(count>(map.keySet().size()-8)){

            }
        }
    }
}
