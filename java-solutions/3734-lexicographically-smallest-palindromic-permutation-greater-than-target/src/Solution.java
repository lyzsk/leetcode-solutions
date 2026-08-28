/**
 *
 * @author sichu huang
 * @since 2026/08/28
 */
public class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        if (n == 1) {
            return s.compareTo(target) > 0 ? s : "";
        }

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        String oddChar = "";
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (oddChar != "") {
                    return "";
                }
                oddChar = String.valueOf((char)('a' + i));
            }
            cnt[i] /= 2;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n / 2; i++) {
            boolean found = false;
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0) {
                    continue;
                }

                cnt[j]--;
                if (check(prefix.toString(), (char)('a' + j), cnt, oddChar,
                    target)) {
                    prefix.append((char)('a' + j));
                    found = true;
                    break;
                } else {
                    cnt[j]++;
                }
            }
            if (!found) {
                return "";
            }

            if (prefix.charAt(i) > target.charAt(i)) {
                StringBuilder left = new StringBuilder(prefix);
                for (int j = 0; j < 26; j++) {
                    left.append(String.valueOf((char)('a' + j))
                        .repeat(Math.max(0, cnt[j])));
                }
                String palindrome =
                    left.toString() + oddChar + new StringBuilder(
                        left).reverse().toString();
                return palindrome;
            }
        }
        String ans =
            prefix.toString() + oddChar + new StringBuilder(prefix).reverse()
                .toString();
        return ans;
    }

    private boolean check(String prefix, char c, int[] cnt, String oddChar,
        String target) {
        StringBuilder left = new StringBuilder(prefix);
        left.append(c);
        for (int i = 25; i >= 0; i--) {
            for (int k = 0; k < cnt[i]; k++) {
                left.append((char)('a' + i));
            }
        }

        String palindrome =
            left.toString() + oddChar + new StringBuilder(left).reverse()
                .toString();

        return palindrome.compareTo(target) > 0;
    }
}
