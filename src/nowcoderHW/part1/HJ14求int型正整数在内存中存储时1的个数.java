package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/23  17:18
 */
public class HJ14求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String s = Integer.toBinaryString(num);
        int onenum=0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if ('1'==ch){
                onenum++;
            }
        }
        System.out.println(onenum);
    }
}

//进制转换
//public String fun(int n,int num) {
//    // n 表示目标进制, num 要转换的值
//    String str= "";
//    int yushu ;      // 保存余数
//    int shang = num;      // 保存商
//    while (shang>0) {
//        yushu = shang %n;
//        shang = shang/n;
//
//        // 10-15 -> a-f
//        if(yushu>9) {
//            str =(char)('a'+(yushu-10)) + str;
//        }else {
//            str = yushu+str;
//        }
//    }
//
//    return str;
//}
