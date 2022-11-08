import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/08
 **/
public class Solution {
    private int res = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        backtrack(masks, 0, 0);
        return res;
    }

    private void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) {
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}
