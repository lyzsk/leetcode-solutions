/**
 * @author sichu huang
 * @date 2024/06/21
 **/
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += (1 - grumpy[i]) * customers[i];
        }

        int windowAll = 0, windowPartial = 0;
        for (int i = 0; i < customers.length; i++) {
            windowAll += customers[i];
            windowPartial += ((1 - grumpy[i]) * customers[i]);
            if (i + 1 >= minutes) {
                res = Math.max(res, total - windowPartial + windowAll);
                int left = i - minutes + 1;
                windowAll -= customers[left];
                windowPartial -= ((1 - grumpy[left]) * customers[left]);
            }
        }
        return res;
    }
}
