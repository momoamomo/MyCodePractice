package odpart;
 /*
    给定两个字符集合
    一个是全量字符集
    一个是已占用字符集
    已占用字符集中的字符不能再使用
    要求输出剩余可用字符集

    输入描述
     1. 输入一个字符串 一定包含@
     @前为全量字符集  @后的为已占用字符集
     2. 已占用字符集中的字符
     一定是全量字符集中的字符
     字符集中的字符跟字符之间使用英文逗号隔开
     3. 每个字符都表示为字符+数字的形式
      用英文冒号分隔
      比如a:1标识一个a字符
     4. 字符只考虑英文字母，区分大小写
      数字只考虑正整型 不超过100
     5. 如果一个字符都没被占用 @标识仍存在
     例如 a:3,b:5,c:2@

     输出描述：
       输出可用字符集
       不同的输出字符集之间用回车换行
       注意 输出的字符顺序要跟输入的一致
       不能输出b:3,a:2,c:2
       如果某个字符已全部占用 则不需要再输出

      示例一：
       输入
       a:3,b:5,c:2@a:1,b:2
       输出
       a:2,b:3,c:2
       说明：
       全量字符集为三个a，5个b，2个c
       已占用字符集为1个a，2个b
       由于已占用字符不能再使用
       因此剩余可用字符为2个a，3个b，2个c
       因此输出a:2,b:3,c:2
     */

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/7  16:21
 */
public class Main63字符集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        int index = str.indexOf("@");
        String all = str.substring(0, index);
        //没有已占用的字符集
        if (index == str.length()) {
            System.out.println(all);
            return;
        }
        //有已占用的字符集
        HashMap<Character, Integer> allMap = new HashMap<>();
        List<String> allList = Stream.of(all.split(",")).collect(Collectors.toList());
        for (String couple : allList) {
            int sp = couple.indexOf(":");
            allMap.put(couple.charAt(0), Integer.parseInt(couple.substring(sp + 1)));
        }
        String aa = str.substring(index+1);
        HashMap<Character, Integer> aaMap = new HashMap<>();
        List<String> aaList = Stream.of(aa.split(",")).collect(Collectors.toList());
        for (String couple : aaList) {
            int sp = couple.indexOf(":");
            aaMap.put(couple.charAt(0), Integer.parseInt(couple.substring(sp + 1)));
        }

        StringBuilder result = new StringBuilder();
        for (Character c:allMap.keySet()) {
            if(!aaMap.keySet().contains(c)){
                result.append(c).append(":").append(allMap.get(c)).append(",");
                continue;
            }
            Integer cha = allMap.get(c)-aaMap.get(c);
            if(cha!=0){
                result.append(c).append(":").append(cha).append(",");
            }
        }
        System.out.println(result.substring(0,result.length()-1));
    }
}
