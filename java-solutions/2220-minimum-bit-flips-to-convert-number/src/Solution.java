/**
 * @author sichu huang
 * @date 2024/09/11
 **/
public class Solution {
    public int minBitFlips(int start, int goal) {
        int num = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                num++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return num;
    }
}
