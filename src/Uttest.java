import java.time.LocalDateTime;

/**
 * @author sunzhilin
 * @date 2020/12/31  16:19
 */
public class Uttest {
    public static void main(String[] args) {
        String startTime = LocalDateTime.now().toString();
        System.out.println(startTime);

        LocalDateTime st = LocalDateTime.now();
        LocalDateTime et = LocalDateTime.now().plusHours(2);
        boolean bb = st.plusDays(1).isAfter(et);
        System.out.println(bb);
        boolean cc = isToday(st);
        System.out.println(cc);
    }

    private static boolean isToday(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        return now.getYear() == time.getYear() && now.getMonth() == time.getMonth()
                && now.getDayOfMonth() == time.getDayOfMonth();
    }
}
