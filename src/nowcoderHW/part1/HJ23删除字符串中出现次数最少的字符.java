package nowcoderHW.part1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/9/29  17:48
 */
public class HJ23删除字符串中出现次数最少的字符 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            int count = 1;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c,count);
                }else{
                    map.put(c,map.get(c)+1);
                }
            }
            int min = Integer.MAX_VALUE;
            for(Character key:map.keySet()){
                if(map.get(key)<min){
                    min = map.get(key);
                }
            }
            char[] array = str.toCharArray();
            StringBuilder result = new StringBuilder();
            for(char c :array){
                if(map.get(c)!= min){
                    result.append(c);
                }
            }

            System.out.println(result.toString());
        }
    }
}
