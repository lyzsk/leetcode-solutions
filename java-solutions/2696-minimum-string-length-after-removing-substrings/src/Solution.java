import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/10/07
 **/
public class Solution {
    public int minLength(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.add(ch);
            int m = list.size();
            if (m >= 2 && (list.get(m - 2) == 'A' && list.get(m - 1) == 'B' || (
                list.get(m - 2) == 'C' && list.get(m - 1) == 'D'))) {
                list.remove(m - 1);
                list.remove(m - 2);
            }
        }
        return list.size();
    }
}
