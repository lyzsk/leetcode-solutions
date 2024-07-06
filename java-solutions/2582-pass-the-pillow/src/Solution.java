/**
 * @author sichu huang
 * @date 2024/07/06
 **/
public class Solution {
    public int passThePillow(int n, int time) {
        int res = time / (n - 1);
        return res % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
}
