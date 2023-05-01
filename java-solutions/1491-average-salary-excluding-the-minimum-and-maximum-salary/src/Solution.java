/**
 * @author sichu
 * @date 2023/05/01
 **/
public class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double sum = 0;
        double minv = Integer.MAX_VALUE;
        double maxv = Integer.MIN_VALUE;
        for (int s : salary) {
            sum += s;
            minv = Math.min(minv, s);
            maxv = Math.max(maxv, s);
        }
        return (sum - minv - maxv) / (n - 2);
    }
}
