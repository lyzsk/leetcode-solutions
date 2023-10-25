/**
 * @author sichu
 * @date 2023/10/25
 **/
public class Solution {
    public int kthGrammar(int n, int k) {
        boolean areValueSame = true;
        n = 1 << (n - 1);
        while (n != 1) {
            n = n >> 1;
            if (k > n) {
                k -= n;
                areValueSame = !areValueSame;
            }
        }
        return areValueSame ? 0 : 1;
    }
}
