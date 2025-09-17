import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/09/12 01:29
 */
public class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int[] cnt = new int[58];
        Arrays.fill(cnt, -1);
        for (char ch : vowels) {
            cnt[ch - 'A'] = 0;
        }

        for (char ch : s.toCharArray()) {
            int i = ch - 'A';
            if (cnt[i] != -1) {
                cnt[i]++;
            }
        }

        char[] arr = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i] - 'A';
            if (cnt[pos] != -1) {
                while (cnt[idx] <= 0) {
                    idx++;
                }
                arr[i] = (char)(idx + 'A');
                cnt[idx]--;
            }
        }

        return new String(arr);
    }
}
