package nowcoderHW.part1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/9/30  16:45
 */
public class HJ34图片整理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            System.out.println(String.valueOf(arr));
        }
    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            char[] arr = str.toCharArray();
//            Arrays.sort(arr);
//            StringBuilder sb = new StringBuilder();
//            for(int i= 0;i<str.length();i++){
//                if(Character.isDigit(arr[i])){
//                    sb.append(arr[i]);
//                }
//            }
//            for(int i =0;i<26;i++){
//                char c = (char)('A'+i);
//                for(int j =0;j<str.length();j++){
//                    if(c==arr[j]||c==arr[j]-'a'+'A'){
//                        sb.append(arr[j]);
//                    }
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }



}
