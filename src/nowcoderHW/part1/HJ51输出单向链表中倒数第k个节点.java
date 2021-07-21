package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2021/7/20  16:33
 */
public class HJ51输出单向链表中倒数第k个节点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            //头节点
            int headNodeVal = scanner.nextInt();
            ListNode head = new ListNode(headNodeVal);
            ListNode rear = head;
            //尾插法
            for (int i = 0; i < n-1; i++) {
                ListNode node = new ListNode(scanner.nextInt());
                node.next = rear.next;
                rear.next = node;
                rear = node;
            }

            int k = scanner.nextInt();
            ListNode fast = head;
            ListNode slow = head;

            while (k > 0) {
                fast = fast.next;
                k--;
            }

            while (n > 0 && fast != null) {
                fast = fast.next;
                slow = slow.next;
                n--;
            }
            System.out.println(slow == null ? 0 : slow.val);
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }
}
