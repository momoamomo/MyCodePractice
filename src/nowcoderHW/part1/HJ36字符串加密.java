package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/3/14  16:18
 */
public class HJ36字符串加密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String key = sc.nextLine();
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] keys = key.toLowerCase().toCharArray();
            char[] maps = new char[26];
            int index = 0;
            for (char ch : keys) {
                boolean flag = true;
                for (int i = 0; i < index; i++) {
                    if (ch==maps[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    maps[index]= ch;
                    index++;
                }
            }
            for (int i = 0; i < 26; i++) {
                boolean flag = true;
                for (int j = 0; j < index; j++) {
                    if(maps[j]-97 == i){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    maps[index] = (char)(i+97);
                    index++;
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>=97){
                    sb.append(maps[str.charAt(i)-97]);
                }else {
                    sb.append((char)(maps[str.charAt(i)-65]-32));
                }

            }
            System.out.println(sb.toString());
        }
    }
}
