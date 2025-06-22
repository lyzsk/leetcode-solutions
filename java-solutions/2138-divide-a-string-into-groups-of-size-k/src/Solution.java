/**
 * @author sichu huang
 * @since 2025/06/22 16:59
 */
public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] res = new String[groups];
        for (int i = 0; i < groups; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int index = i * k + j;
                if (index < n) {
                    group.append(s.charAt(index));
                } else {
                    group.append(fill);
                }
            }
            res[i] = group.toString();
        }

        return res;
    }
}
