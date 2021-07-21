package testLocal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author sunzhilin
 * @date 2020/10/3  17:43
 */
public class HWTest2020100303 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int distant = sc.nextInt();
            map.put(id,distant);
        }
        for (int i = 0; i < m; i++) {
            Node node = new Node();
            int id1 = sc.nextInt();
            int id2 = sc.nextInt();
            int distant = sc.nextInt();
            node.setId1(id1);
            node.setId2(id2);
            node.setDistance(distant);

        }
        int sum = 0;
        if(m==0){
            for(Integer dis :map.values()){
                sum +=dis;
            }
            System.out.println(sum*2);
        }

    }
    public static class Node{
        private int id1;
        private int id2;
        private int distance;

        public int getId1() {
            return id1;
        }

        public int getId2() {
            return id2;
        }

        public int getDistance() {
            return distance;
        }

        public void setId1(int id1) {
            this.id1 = id1;
        }

        public void setId2(int id2) {
            this.id2 = id2;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
