package split;

/**
 * @author sichu
 * @date 2022/08/19
 **/
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ++res;
            }
        }
        return res;
    }
}
