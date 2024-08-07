import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/08/06
 **/
public class Solution {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char b : word.toCharArray()) {
            ++cnt[b - 'a'];
        }
        Arrays.sort(cnt);
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += cnt[25 - i] * (i / 8 + 1);
        }
        return res;
    }
}
