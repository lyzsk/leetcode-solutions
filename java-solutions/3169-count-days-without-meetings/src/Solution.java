import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2025/03/24 17:46
 */
public class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int available = 0, prevMeeting = 0;
        for (int[] meeting : meetings) {
            available += Math.max(meeting[0] - prevMeeting - 1, 0);
            prevMeeting = Math.max(prevMeeting, meeting[1]);
        }
        available += days - prevMeeting;
        return available;
    }
}
