/**
 * @author sichu
 * @date 2023/02/13
 **/
public class Solution {
    public int balancedString(String s) {
        int[] cnt = new int[4];
        String temp = "QWER";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ++cnt[temp.indexOf(s.charAt(i))];
        }
        int m = n / 4;
        if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
            return 0;
        }
        int res = n;
        for (int i = 0, j = 0; i < n; i++) {
            --cnt[temp.indexOf(s.charAt(i))];
            while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
                res = Math.min(res, i - j + 1);
                ++cnt[temp.indexOf(s.charAt(j++))];
            }
        }
        return res;
    }
}
