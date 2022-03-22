package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author szl
 * @date 2022/2/26  15:16
 */
public class HW1 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        int min1 = getMin(timePoints.get(0));
        int firt = min1;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMin(timePoints.get(i));
            res = Math.min(minutes - firt, res);
            firt = minutes;
        }
        res = Math.min(res, min1 + 1440 - getMin(timePoints.get(timePoints.size() - 1)));
        System.out.println(res);
    }

    public static int getMin(String time) {
        int result =
                ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return result;
    }
}
