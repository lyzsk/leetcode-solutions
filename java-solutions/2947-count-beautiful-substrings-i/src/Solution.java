import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2026/01/15 16:34
 */
public class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for (int i = 0; i < n; i++) {
            int vCount = 0;
            int cCount = 0;
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (set.contains(Character.toLowerCase(ch))) {
                    vCount++;
                } else {
                    cCount++;
                }
                if (((vCount == cCount) && ((vCount * cCount) % k == 0))) {
                    count++;
                }
            }
        }
        return count;
    }
}
