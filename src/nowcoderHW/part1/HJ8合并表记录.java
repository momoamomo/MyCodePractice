package nowcoderHW.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author sunzhilin
 * @date 2020/8/16  20:10
 */
public class HJ8合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer > map = new TreeMap<Integer, Integer>();
        while (n>0){
            int k = sc.nextInt();
            int v = sc.nextInt();
            if(map.containsKey(k)){
                map.put(k,map.get(k)+v);
            }else{
                map.put(k,v);
            }
            n--;
        }
        for (Integer k: map.keySet()){
            System.out.println(k+" "+map.get(k));
        }
    }
}
