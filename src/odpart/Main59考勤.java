package odpart;
/*
  公司用一个字符串来标识员工的出勤信息

  absent:    缺勤
  late:      迟到
  leaveearly:早退
  present:   正常上班

  现需根据员工出勤信息,判断本次是否能获得出勤奖,
  能获得出勤奖的条件如下：
      1.缺勤不超过1次
      2.没有连续的迟到/早退
      3.任意连续7次考勤 缺勤/迟到/早退 不超过3次

   输入描述：
    用户的考勤数据字符串记录条数  >=1
    输入字符串长度 <10000 ;
    不存在非法输入
    如：
     2
     present
     present absent present present leaveearly present absent

    输出描述：
    根据考勤数据字符串
    如果能得到考勤奖输出true否则输出false
    对于输出示例的结果应为
     true false

    示例一：
     输入：
      2
      present
      present present

     输出：
      true true

    示例二
     输入：
      2
      present
      present absent present present leaveearly present absent
     输出：
      true false

   */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/2/8  17:33
 */
public class Main59考勤 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<String> list = Stream.of(sc.nextLine().split(" ")).collect(Collectors.toList());
            if (isOk(list)) {
                sb.append("true").append(" ");
            } else {
                sb.append("false").append(" ");
            }
        }

        //拿奖
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    public static boolean isOk(List<String> list) {
        String qq = "absent";
        String cd = "late";
        String zt = "leaveearly";
        String moral = "present";

        //缺勤不超过1次
        long count = list.stream().filter(o -> qq.equals(o)).count();
        if (count > 1) {
            return false;
        }
        //连续迟到、早退
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(cd) || list.get(i).equals(zt)) {
                if (list.get(i - 1).equals(cd) || list.get(i - 1).equals(zt)) {
                    return false;
                }
            }
        }
        //3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
        if (list.size() <= 7 && list.stream().filter(o -> !qq.equals(o)).count() > 3) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(moral)) {
                List<String> subList = list.subList(i, i + 6);
                if (subList.stream().filter(o -> !qq.equals(o)).count() > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
