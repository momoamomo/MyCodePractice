package nowcoderHW.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.io.*;

/**
 * @author sunzhilin
 * @date 2020/8/28  15:54
 */

public class HJ17坐标移动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> bs = new ArrayList<String>() {{
            add("A");
            add("D");
            add("W");
            add("S");
        }};
        List<String> list = Stream.of(str.split(";")).collect(Collectors.toList());
        int xsum = 0;
        int ysum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String e : list) {
            if (e.length() == 2 || e.length() == 3) {
                String dir = Character.toString(e.charAt(0));
                String dis = e.substring(1);
                if (bs.contains(dir)) {
                    if (Character.isDigit(e.charAt(1))&&Character.isDigit(e.charAt(2))) {
                        int distance = Integer.valueOf(dis);
                        if (dir.equals("A")) {
                            xsum += -distance;
                        }
                        if (dir.equals("D")) {
                            xsum += distance;
                        }
                        if (dir.equals("W")) {
                            ysum += distance;
                        }
                        if (dir.equals("S")) {
                            ysum += -distance;
                        }
                    }
                }
            }
        }
        System.out.println(xsum + "," + ysum);

    }

    //方法二：利用数组接收，查找快，数字按位计算
    /*public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str=reader.readLine())!=null){
            String[] cur=str.split(";");
            int x=0;
            int y=0;
            for(int i=0;i<cur.length;i++){
                char[] arr=cur[i].toCharArray();
                int change=0;
                for(int j=1;j<arr.length;j++){
                    if(arr[j]>='0'&&arr[j]<='9'){
                        change=change*10+(arr[j]-'0');
                    }else{
                        break;
                    }
                }
                switch(arr[0]){
                    case 'A':
                        x-=change;
                        break;
                    case 'D':
                        x+=change;
                        break;
                    case 'W':
                        y+=change;
                        break;
                    case 'S':
                        y-=change;
                        break;
                }
            }
            System.out.println(x+","+y);
        }
    }*/
}



