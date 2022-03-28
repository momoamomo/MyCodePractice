package testLocal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class 考勤v2 {
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
        if (list.size() <= 7 && list.stream().filter(o -> !moral.equals(o)).count() > 3) {
            return false;
        }
        //连续7次考勤，一条记录里，最后一个连续7次的起始位置在list.size()-7即i < list.size()-6
        //连续7次的第一次为异常才去判断，第一次为正常上班，可直接跳下个7次
        for (int i = 0; i < list.size()-6; i++) {
            if (!list.get(i).equals(moral)) {
                List<String> subList = list.subList(i, i + 7);
                if (subList.stream().filter(o -> !moral.equals(o)).count() >3) {
                    return false;
                }
            }
        }
        return true;
    }
}
