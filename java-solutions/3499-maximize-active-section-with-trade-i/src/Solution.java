import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/07/21
 */
public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> list = new ArrayList<>();
        int len = 0;

        for (char c : s.toCharArray())
            if (c == '1') {
                if (len != 0) {
                    list.add(len);
                    len = 0;
                }
            } else
                len++;

        if (len != 0)
            list.add(len);

        int count = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                count++;

        if (list.size() <= 1)
            return count;

        int max = 0;
        for (int i = 0; i < list.size() - 1; i++)
            max = Math.max(max, list.get(i) + list.get(i + 1));

        return count + max;
    }
}
