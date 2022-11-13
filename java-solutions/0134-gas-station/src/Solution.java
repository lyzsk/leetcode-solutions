/**
 * @author sichu
 * @date 2022/11/13
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int gasSum = 0;
            int costSum = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                gasSum += gas[j];
                costSum += cost[j];
                if (costSum > gasSum) {
                    break;
                }
                ++cnt;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
