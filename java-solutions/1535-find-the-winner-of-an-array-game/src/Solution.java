import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/11/05
 **/
public class Solution {
    public int getWinner(int[] arr, int k) {
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int n = arr.length;
        if (k >= n) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int curWinner = arr[0];
        int winCnt = 0;
        for (int i = 1; i < n; i++) {
            if (curWinner > arr[i]) {
                ++winCnt;
            } else {
                curWinner = arr[i];
                winCnt = 1;
            }
            if (winCnt == k) {
                return curWinner;
            }
        }
        return curWinner;
    }
}
