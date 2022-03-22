package odpart;

/*
   某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
   现需要按照身高由低到高排列，
   对身高相同的人，按体重由轻到重排列，
   对于身高体重都相同的人，维持原有的编号顺序关系。
   请输出排列后的学生编号
   输入描述：
      两个序列，每个序列由N个正整数组成，(0<n<=100)。
      第一个序列中的数值代表身高，第二个序列中的数值代表体重，
   输出描述：
      排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
   实例一：
      输入:
       4
       100 100 120 130
       40 30 60 50
      输出:
       2134
   */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/1/27  18:03
 */
public class Main79运动会身高体重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> hs = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ws = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        sc.close();
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Student student = new Student(i, hs.get(i - 1), ws.get(i - 1));
            studentList.add(student);
        }
        List<Student> list = studentList.stream().sorted((s1, s2) -> {
            return s1.high == s2.high ? s1.weight - s2.weight : s1.high - s2.high;
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        list.forEach(item -> sb.append(item.id));
        System.out.println(sb.toString());

    }

    static class Student {
        private int id;
        private int high;
        private int weight;

        public Student(int id, int h, int w) {
            this.id = id;
            this.high = h;
            this.weight = w;
        }
    }

    //解法二：二维数组
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] h = sc.nextLine().split(" ");
        String[] w = sc.nextLine().split(" ");
        sc.close();
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            ints[i][0] = i + 1;
            ints[i][1] = Integer.parseInt(h[i]);
            ints[i][2] = Integer.parseInt(w[i]);
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                //身高
                if (arr1[1] == arr2[1]) {return arr1[2] - arr2[2];}
                else {return arr1[1] - arr2[1];}
            }
        });
        for (int[] anInt : ints) {
            System.out.print(anInt[0] + " ");
        }
    }*/


}
