package nowcoderHW.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/7/20  10:27
 */
public class HJ48从单向链表中删除指定值的节点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int headNode = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(headNode);
            for (int i = 0; i < len - 1; i++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();
                int index = list.indexOf(node2);
                list.add(index + 1, node1);
            }
            int deleteNode = sc.nextInt();
            int deleteNodeIndex = list.indexOf(deleteNode);
            list.remove(deleteNodeIndex);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
        sc.close();

    }
}
