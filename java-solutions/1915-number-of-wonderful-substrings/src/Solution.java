/**
 * @author sichu huang
 * @date 2024/04/30
 **/
public class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        long res = 0;
        int prefixXor = 0;
        count[prefixXor] = 1;
        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            prefixXor ^= 1 << charIndex;
            res += count[prefixXor];
            for (int i = 0; i < 10; i++) {
                res += count[prefixXor ^ (1 << i)];
            }
            count[prefixXor]++;
        }
        return res;
    }
}
