/**
 * @author sichu huang
 * @since 2024/12/17 17:16
 */
public class Solution {
    private static int N = 26;

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[N];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int m = 0;
        for (int i = N - 1, j = N - 2; i >= 0 && j >= 0; ) {
            if (count[i] == 0) {
                m = 0;
                i--;
            } else if (m < repeatLimit) {
                count[i]--;
                sb.append((char)('a' + i));
                m++;
            } else if (j >= i || count[j] == 0) {
                j--;
            } else {
                count[j]--;
                sb.append((char)('a' + j));
                m = 0;
            }
        }
        return sb.toString();
    }
}
