import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu huang
 * @since 2024/12/10 20:18
 */
public class Solution {
    public int maximumLength(String s) {
        int res = -1;
        int len = s.length();
        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<>();
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;
            if (i + 1 == len || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;

                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }

                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!chs[i].isEmpty() && chs[i].get(0) > 2) {
                res = Math.max(res, chs[i].get(0) - 2);
            }
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                res = Math.max(res, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            if (chs[i].size() > 2) {
                res = Math.max(res, chs[i].get(2));
            }
        }
        return res;
    }
}
