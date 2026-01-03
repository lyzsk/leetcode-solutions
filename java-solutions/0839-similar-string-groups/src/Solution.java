/**
 * @author sichu huang
 * @since 2025/12/30 16:15
 */
public class Solution {
    private int[] f;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    f[fi] = fj;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    private boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
