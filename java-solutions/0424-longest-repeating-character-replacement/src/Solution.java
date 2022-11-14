/**
 * @author sichu
 * @date 2022/11/14
 **/
public class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return n;
        }
        int[] freq = new int[26];
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            int idx = chs[right] - 'A';
            ++freq[idx];
            max = Math.max(freq[idx], max);
            if (right - left + 1 > max + k) {
                --freq[chs[left] - 'A'];
                ++left;
            }
            ++right;
        }
        return n - left;
    }
}
