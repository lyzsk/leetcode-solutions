/**
 * @author sichu
 * @date 2022/11/23
 **/
public class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 1) {
            --low;
        }
        if (high % 2 == 1) {
            ++high;
        }
        return (high - low) >> 1;
    }
}
