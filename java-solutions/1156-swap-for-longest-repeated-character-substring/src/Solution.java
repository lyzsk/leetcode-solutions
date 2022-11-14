/**
 * @author sichu
 * @date 2022/11/14
 **/
public class Solution {
    public int maxRepOpt1(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < text.length(); i++) {
            char cur = text.charAt(i);
            int j = i;
            int cnt = 0;
            int diff = 0;
            while (j < text.length() && (cur == text.charAt(j) || diff == 0) && cnt < freq[cur - 'a']) {
                if (cur != text.charAt(j)) {
                    ++diff;
                    i = j - 1;
                }
                ++cnt;
                ++j;
            }
            max = Math.max(max, cnt);
        }
        for (int i = text.length() - 1; i >= 0; i--) {
            char cur = text.charAt(i);
            int j = i;
            int cnt = 0;
            int diff = 0;
            while (j >= 0 && (cur == text.charAt(j) || diff == 0) && cnt < freq[cur - 'a']) {
                if (cur != text.charAt(j)) {
                    ++diff;
                    i = j + 1;
                }
                ++cnt;
                --j;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
