package nowcoderHW.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author szl
 * @date 2022/2/23  23:11
 */
public class 栈和队列互相实现 {
    //两个栈实现队列
    public static class TwoStackToQueue {
        Stack<Integer> A;
        Stack<Integer> B;

        public TwoStackToQueue() {
            this.A = new Stack<>();
            this.B = new Stack<>();
        }

        public void push(int num) {
            A.add(num);
            if (this.B.empty()) {
                B.add(A.pop());
            }
        }

        public int pop() {
            if (B.empty()) {
                if (A.empty()) {
                    System.out.println("队列为空");
                } else {
                    while (A.size() > 0) {
                        B.add(A.pop());
                    }
                }
            }
            int value = B.pop();
            return value;
        }

        public int peek() {
            if (B.empty()) {
                if (A.empty()) {
                    System.out.println("队列为空");
                } else {
                    while (A.size() > 0) {
                        B.add(A.pop());
                    }
                }
            }
            int value = B.pop();
            A.add(value);
            return value;
        }

    }

    //两个队列实现栈
    public static class TwoQueueToStack {
        Queue<Integer> Q1;
        Queue<Integer> Q2;

        public TwoQueueToStack() {
            Q1 = new LinkedList<>();
            Q2 = new LinkedList<>();
        }

        //压栈
        public void push(int num) {
            Q1.add(num);
        }

        //出栈
        public int pop() {
            if (Q1.isEmpty()) {
                System.out.println("栈空");
            }
            //把队列中的除最后一个元素都放入另一个队列
            while (Q1.size() > 1) {
                Q2.add(Q1.poll());
            }
            int value = Q1.poll();
            //两个队列互换
            swap();
            return value;

        }

        public void swap() {
            Queue<Integer> tmp = Q2;
            Q2 = Q1;
            Q1 = tmp;
        }
    }
}
