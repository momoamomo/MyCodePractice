package odpart;
 /*
          有一个简易内存池，内存按照大小粒度分类
          每个粒度有若干个可用内存资源
          用户会进行一系列内存申请
          需要按需分配内存池中的资源
          返回申请结果成功失败列表
          分配规则如下
          1.分配的内存要大于等于内存的申请量
          存在满足需求的内存就必须分配
          优先分配粒度小的，但内存不能拆分使用
          2.需要按申请顺序分配
          先申请的先分配，有可用内存分配则申请结果为true
          没有可用则返回false
          注释：不考虑内存释放

          输入描述
          输入为两行字符串
          第一行为内存池资源列表
          包含内存粒度数据信息，粒度数据间用逗号分割
          一个粒度信息内用冒号分割
          冒号前为内存粒度大小，冒号后为数量
          资源列表不大于1024
          每个粒度的数量不大于4096

          第二行为申请列表
          申请的内存大小间用逗号分割，申请列表不大于100000

          如
          64:2,128:1,32:4,1:128
          50,36,64,128,127

          输出描述
          输出为内存池分配结果
          如true,true,true,false,false

          示例一：
          输入：
          64:2,128:1,32:4,1:128
          50,36,64,128,127
          输出：
          true,true,true,false,false

          说明:
          内存池资源包含：64k共2个、128k共1个、32k共4个、1k共128个的内存资源
          针对50,36,64,128,127的内存申请序列，
          分配的内存依次是，64,64,128,null,null
          第三次申请内存时已经将128分配出去，因此输出的结果是
          true,true,true,false,false
         */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/13  14:36
 */
public class Main33内存池分配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> pool = new TreeMap<>();
        Arrays.stream(sc.nextLine().split(",")).forEach(e -> {
            String[] split = e.split(":");
            pool.put(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]));
        });

        List<Integer> goals =
                Stream.of(sc.nextLine().split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());

        sc.close();

        //一个申请资源查找可用池子的时候从小到大查找，所以要用treeMap
        StringBuilder sb = new StringBuilder();
        for (Integer goal : goals) {
            boolean flag = false;
            for (Integer k : pool.keySet()) {
                Integer v = pool.get(k);
                if (k >= goal && v != 0) {
                    pool.put(k, v - 1);
                    flag = true;
                    break;
                }

            }
            if (flag) {
                sb.append("true,");
            } else {
                sb.append("false,");

            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
