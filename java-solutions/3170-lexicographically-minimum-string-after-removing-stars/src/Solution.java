import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/06/07 23:39
 */
public class Solution {
    public String clearStars(String s) {
        Deque<Integer>[] cnt = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                res.append(c);
            }
        }
        return res.toString();
    }
}
