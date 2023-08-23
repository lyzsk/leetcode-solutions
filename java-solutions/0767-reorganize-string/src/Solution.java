/**
 * @author sichu
 * @date 2023/08/23
 **/
public class Solution {
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] cnt = new int[26];
        for (char ch : arr) {
            ++cnt[ch - 'a'];
        }
        int maxIdx = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > cnt[maxIdx]) {
                maxIdx = i;
            }
        }
        if (cnt[maxIdx] > (n + 1) >> 1) {
            return "";
        }
        // max char put in even indices
        char[] res = new char[n];
        int i = 0;
        while (cnt[maxIdx]-- > 0) {
            res[i] = (char)('a' + maxIdx);
            i += 2;
        }
        // other chars
        for (int j = 0; j < 26; j++) {
            while (cnt[j]-- > 0) {
                // if all even indices used, then put in odd indices
                if (i >= n) {
                    i = 1;
                }
                res[i] = (char)('a' + j);
                i += 2;
            }
        }
        return String.valueOf(res);
    }
}
