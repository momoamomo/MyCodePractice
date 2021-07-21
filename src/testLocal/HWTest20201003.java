package testLocal;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/10/3  15:41
 */
public class HWTest20201003 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.length() < 3 || i >= s.length() - 2) {
                    sb.append((char) (s.charAt(i) + 48));
                    continue;
                }
                if (s.charAt(i + 2) != '*') {
                    sb.append((char) (s.charAt(i) + 48));
                } else {
                    sb.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 96));
                    i += 2;
                }
            }
            System.out.println(sb.toString());

        }

//            for(int i = str.length()-1;i>=0;){
//                char ch = str.charAt(i);
//                String ss;
//                if(ch =='*'){
//                    ss = str.substring(i-2,i);
//                    i=i-3;
//                }else{
//                    ss = str.substring(i);
//                }
//                int num = Integer.valueOf(ss);
//                char cc = (char)('a'+num-1);
//                sb.append(cc);
//            }
//            System.out.println(sb.toString());
//        }
    }
}
