package odpart;
 /*
            输入一个字符串仅包含大小写字母和数字
            求字符串中包含的最长的非严格递增连续数字序列长度
            比如：
                12234属于非严格递增数字序列
            示例：
            输入
                abc2234019A334bc
            输出
                4
            说明：
                2234为最长的非严格递增连续数字序列，所以长度为4

                aaaaaa44ko543j123j7345677781
                aaaaa34567778a44ko543j123j71
                345678a44ko543j123j7134567778aa
         */

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * @author szl
 * @date 2022/2/11  17:06
 */
public class Main51非严格递增序列长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        int currlen = 0, maxlen = 0;
        char last = 'a';
        char[] chars = str.toCharArray();
        for (char cur : chars) {
            if (Character.isDigit(cur)) {
                if (currlen == 0) {//第一个数字
                    currlen++;
                } else if (cur >= last) { //递增或相等
                    currlen++;
                } else {
                    maxlen = Math.max(maxlen, currlen);
                    currlen = 1;

                }
                last = cur;

            } else {
                if (currlen > maxlen) {
                    maxlen = currlen;
                }
                currlen = 0;
                last = 'a';
            }
        }
        maxlen = Math.max(currlen, maxlen);
        System.out.println(maxlen);
    }
}
