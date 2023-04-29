import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/04/29
 **/
public class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            ++freq[word.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            --freq[i];
            Set<Integer> set = new HashSet<>();
            for (int f : freq) {
                if (f > 0) {
                    set.add(f);
                }
            }
            if (set.size() == 1) {
                return true;
            }
            ++freq[i];
        }
        return false;
    }
}
