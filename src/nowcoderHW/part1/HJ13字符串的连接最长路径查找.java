package nowcoderHW.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/23  15:40
 */
public class HJ13字符串的连接最长路径查找 {
    //方法一：利用List
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        while (n >= 0) {
            String str = sc.nextLine();
            list.add(str);
            n--;
        }
        Collections.sort(list);
        for (String ss : list) {
            System.out.println(ss);
        }
    }*/
    //方法二：利用数组
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] s = new String[num];
        for (int i = 0; i < num; i++) {
            s[i]= br.readLine();
        }
        Arrays.sort(s);
        for (int i = 0; i < num; i++) {
            System.out.println(s[i]);
        }
    }
}
