/**
 * @author sichu
 * @date 2023/04/17
 **/
public class Solution {
    private final int[] DAYS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDays = getDays(arriveAlice);
        int leaveAliceDays = getDays(leaveAlice);
        int arriveBobDays = getDays(arriveBob);
        int leaveBobDays = getDays(leaveBob);
        return Math.max(0, (Math.min(leaveAliceDays, leaveBobDays) - Math.max(arriveAliceDays, arriveBobDays)) + 1);
    }

    private int getDays(String date) {
        int days = 0;
        int month = 10 * (date.charAt(0) - '0') + (date.charAt(1) - '0');
        int day = 10 * (date.charAt(3) - '0') + (date.charAt(4) - '0');
        for (int i = 1; i < month; i++) {
            days += DAYS[i - 1];
        }
        return days + day;
    }
}
