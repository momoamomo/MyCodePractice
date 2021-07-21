package testLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/10/3  16:22
 */
public class HWTest2020100302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> listin = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            String s = sc.next();
            listin.add(s);
        }
        for (String s:listin){
            if(s!=""){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    //
                    char num1 = s.charAt(i);
                    int num2 = fun(i);
                    int num3 = num1+num2;
                    if(num3>=97&&num3<122){
                        char ch = (char)(s.charAt(i)+fun(i)) ;
                        sb.append(ch);
                    }else {
                        int num4 = 97+(num3-97)%26;
                        char ch = (char)(num4);
                        sb.append(ch);
                    }
                }
                System.out.println(sb.toString());
            }

        }
    }

    public static int fun(int i){
        if(i==0){
            return 1;
        }
        if(i==1){
            return 2;
        }
        if(i==2){
            return 4;
        }else {
            return fun(i-1)+fun(i-2)+fun(i-3);
        }
    }
}
