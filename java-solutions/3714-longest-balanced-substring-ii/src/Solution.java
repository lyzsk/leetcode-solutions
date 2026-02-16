import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2026/02/13 16:16
 */
public class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;

        int last = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                last++;
            } else {
                last = 1;
            }
            res = Math.max(res, last);
        }

        res = Math.max(res, case2Helper(s, 'a', 'b'));
        res = Math.max(res, case2Helper(s, 'b', 'c'));
        res = Math.max(res, case2Helper(s, 'a', 'c'));

        class Key {
            final int x, y;

            Key(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Key key = (Key)o;
                return x == key.x && y == key.y;
            }

            @Override
            public int hashCode() {
                return 31 * x + y;
            }
        }

        Map<Key, Integer> h = new HashMap<>();
        h.put(new Key(n, n), -1);

        int diffAB = 0;
        int diffBC = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                diffAB--;
            } else if (c == 'b') {
                diffAB++;
                diffBC++;
            } else {
                diffBC--;
            }

            Key key = new Key(diffAB + n, diffBC + n);
            Integer prev = h.get(key);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                h.put(key, i);
            }
        }
        return res;
    }

    private int case2Helper(String s, char x, char y) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != x && s.charAt(i) != y) {
                continue;
            }
            Map<Integer, Integer> h = new HashMap<>();
            h.put(0, i - 1);
            int diff = 0;
            int j = i;
            while (j < n && (s.charAt(j) == x || s.charAt(j) == y)) {
                diff += (s.charAt(j) == x) ? 1 : -1;
                Integer prev = h.get(diff);
                if (prev != null) {
                    res = Math.max(res, j - prev);
                } else {
                    h.put(diff, j);
                }
                j++;
            }
            i = j - 1;
        }
        return res;
    }
}
