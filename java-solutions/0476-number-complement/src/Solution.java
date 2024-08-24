/**
 * @author sichu huang
 * @date 2024/08/22
 **/
public class Solution {
    public int findComplement(int num) {
        int x = 0;
        for (int i = num; i != 0; i -= i & -i) {
            x = i;
        }
        return ~num & (x - 1);
    }
}
