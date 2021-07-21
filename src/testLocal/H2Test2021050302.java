package testLocal;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/5/3  11:47
 */
public class H2Test2021050302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ss = sc.nextLine();
            String[] as = ss.split(",");
            if (as.length == 0) {
                System.out.println("/");
            } else {
                String before = as[0];
                if (before.length() > 100) {
                    System.out.println("-1");
                }
                String after = as[1];
                if (after.length() > 100) {
                    System.out.println("-1");
                }
                //去/

//                while (before.length()>0) {
//                    if(before.endsWith("/")){
//                        before = before.substring(0,before.length()-1);
//                    }else {
//                        break;
//                    }
//
//                }
                before = before.replaceAll("/+$", "");

//                while (after.length()>0) {
//                    if(after.startsWith("/")){
//                        before = before.substring(1);
//                    }else {
//                        break;
//                    }
//
//                }
                after = after.replaceAll("^/+", "");
                System.out.println(before + "/" + after);
            }


        }

    }
}
