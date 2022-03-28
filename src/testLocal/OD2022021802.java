package testLocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author szl
 * @date 2022/2/13  14:56
 */
public class OD2022021802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
        ArrayList<List<String>> days = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] ss = sc.nextLine().split(" ");
            List<String> lists = Arrays.stream(ss).collect(Collectors.toList());
            days.add(lists);
        }

        sc.close();
        StringBuilder sb = new StringBuilder();
        for (List<String> day : days) {
            //缺勤不超过1次
            long abs = day.stream().filter(e -> "absent".equals(e)).count();
            if (abs > 1) {
                sb.append("false").append(" ");
                continue;
            }
            //
            boolean flag = true;
            for (int i = 0; i < day.size() - 1; i++) {
                String curr = day.get(i);
                String next = day.get(i + 1);
                if (("late".equals(curr) || "leaveearly".equals(curr)) && ("late".equals(next) || "leaveearly".equals(curr))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                sb.append(flag).append(" ");
                continue;
            }

            int[] nums = new int[day.size()];
            for (int i = 0; i < day.size(); i++) {
                nums[i] = "present".equals(day.get(i)) ? 0 : 1;
            }
            if (nums.length <= 7 && Arrays.stream(nums).sum() >= 3) {
                sb.append("false").append(" ");
            } else {
                flag = true;
                for (int i = 0; i < nums.length - 7; i++) {
                    int[] sub = Arrays.copyOfRange(nums, i, i + 7);
                    if (Arrays.stream(sub).sum() >= 3) {
                        flag = false;
                        break;
                    }
                }
                sb.append(flag).append(" ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}
