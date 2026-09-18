import java.util.*;

/**
 *
 * @author sichu huang
 * @since 2026/09/18
 */
public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, int[]> pos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!pos.containsKey(ch)) {
                pos.put(ch, new int[] {i, i});
            } else {
                pos.get(ch)[1] = i;
            }
        }

        List<int[]> valid = new ArrayList<>();

        for (Map.Entry<Character, int[]> entry : pos.entrySet()) {
            int[] range = entry.getValue();
            int l = range[0], r = range[1];
            int nl = l, nr = l;

            while (nl >= l || nr <= r) {
                int i = (nl >= l) ? nl : nr;
                int[] currentRange = pos.get(s.charAt(i));
                int l_t = currentRange[0];
                int r_t = currentRange[1];
                if (l_t < l) {
                    l = l_t;
                }
                if (r_t > r) {
                    r = r_t;
                }
                if (i == nl) {
                    nl--;
                }
                if (i == nr) {
                    nr++;
                }
            }

            valid.add(new int[] {l, r});
        }
        valid.sort(Comparator.comparingInt(o -> o[1]));
        List<String> res = new ArrayList<>();
        int end = -1;

        for (int[] interval : valid) {
            int left = interval[0];
            int right = interval[1];

            if (left > end) {
                res.add(s.substring(left, right + 1));
                end = right;
            }
        }

        return res;
    }
}
