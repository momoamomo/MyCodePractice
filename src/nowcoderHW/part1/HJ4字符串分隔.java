package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/15  15:29
 */
public class HJ4字符串分隔 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            while(str.length()>=8){
                System.out.println(str.substring(0,8));
                str = str.substring(8);
            }
            if(str.length()>0){
                StringBuffer buffer = new StringBuffer();
                buffer.append(str);
                buffer.append("00000000");
                str = buffer.toString().substring(0,8);
                System.out.println(str);
            }

        }
    }
}
