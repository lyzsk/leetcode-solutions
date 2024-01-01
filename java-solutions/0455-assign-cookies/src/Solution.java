import java.util.Arrays;

/**
 * @author sichu
 * @date 2024/01/01
 **/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookieNum = s.length;
        if (s == null || cookieNum == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int cookieIdx = cookieNum - 1;
        int childIdx = g.length - 1;
        while (cookieIdx >= 0 && childIdx >= 0) {
            if (s[cookieIdx] >= g[childIdx]) {
                ++res;
                --cookieIdx;
                --childIdx;
            } else {
                --childIdx;
            }
        }
        return res;
    }
}
