/**
 * @author sichu huang
 * @date 2024/05/24
 **/
public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int res = 0;
        int[] count = new int[26];
        for (char ch : letters) {
            ++count[ch - 'a'];
        }
        for (int s = 1; s < (1 << n); s++) {
            int[] wordCount = new int[26];
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                for (int i = 0; i < words[k].length(); i++) {
                    char ch = words[k].charAt(i);
                    ++wordCount[ch - 'a'];
                }
            }
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += score[i] * wordCount[i];
                ok = ok && (wordCount[i] <= count[i]);
            }
            if (ok) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
