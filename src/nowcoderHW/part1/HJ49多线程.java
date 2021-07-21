package nowcoderHW.part1;

/**
 * 描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD
 * 的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 * void init();  //初始化函数
 * void Release(); //资源释放函数
 * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
 * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
 * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
 * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
 * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
 * <p>
 * 输入描述：
 * 本题含有多个样例输入。
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 对于每组样例，输出多个ABCD
 * <p>
 * 示例1
 * 输入：
 * 10
 * 复制
 * 输出：
 * ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
 */

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhilin
 * @date 2021/7/20  14:38
 */
public class HJ49多线程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            CountDownLatch countDownLatch = new CountDownLatch(4);
            AlternativePrint alternativePrint = new AlternativePrint();
            //创建线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < num; i++) {
                            alternativePrint.printA();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < num; i++) {
                            alternativePrint.printB();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < num; i++) {
                            alternativePrint.printC();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < num; i++) {
                            alternativePrint.printD();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();

            try {
                countDownLatch.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

}

class AlternativePrint {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    private int n = 1;

    void printA() {
        lock.lock();
        try {
            if (n != 1) {
                conditionA.await();
            }
            System.out.print("A");
            //"A"打印结束，标记置为2，并唤醒打印"B"的线程
            n = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printB() {
        lock.lock();
        try {
            if (n != 2) {
                conditionB.await();
            }
            System.out.print("B");
            n = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            if (n != 3) {
                conditionC.await();
            }
            System.out.print("C");
            //"A"打印结束，标记置为2，并唤醒打印"B"的线程
            n = 4;
            conditionD.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printD() {
        lock.lock();
        try {
            if (n != 4) {
                conditionD.await();
            }
            System.out.print("D");
            //"A"打印结束，标记置为2，并唤醒打印"B"的线程
            n = 5;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
