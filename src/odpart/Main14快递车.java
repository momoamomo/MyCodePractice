package odpart;
/*
        一辆运送快递的货车
        运送的快递放在大小不等的长方体快递盒中
        为了能够装载更多的快递同时不能让货车超载
        需要计算最多能装多少个快递
        注：快递的体积不受限制
        快递数最多1000个
        货车载重最大50000
        输入描述
         第一行输入每个快递的重量
         用英文逗号隔开
         如 5,10,2,11
         第二行输入货车的载重量
          如 20
        输出描述
         输出最多能装多少个快递
         如 3
         示例一
          输入
          5,10,2,11
          20
          输出
          3
         */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/1/29  15:26
 */
public class Main14快递车 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //思路：先排序，从小到大放入车中，超过总量即为最大数
        List<Integer> list = Stream.of(sc.nextLine().split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int max = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if(sum<=max){
                num++;
            }else {
                break;
            }
        }
        System.out.println(num);

    }
}

