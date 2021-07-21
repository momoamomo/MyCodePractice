package nowcoderHW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.isDigit;

/**
 * @author sunzhilin
 * @date 2020/9/28  11:15
 */
public class Try {
    public static void main(String[] args) {
        String str =  "C:/dsfgniwheigh/sdfsj/sdhngiw.java 256";
        int index = str.indexOf(" ");
        String file = str.substring(0,index);
        String number = str.substring(index+1);
        System.out.println(index);
        System.out.println(file);
        System.out.println(number);
        Map<Character,Integer> map = new HashMap<>();

        char[] array = str.toCharArray();
        char ch = str.charAt(2);
        isDigit(ch);
    }
}
