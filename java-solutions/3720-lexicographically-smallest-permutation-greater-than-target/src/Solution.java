/**
 *
 * @author sichu huang
 * @since 2026/08/27
 */
public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        int n = target.length();
        for (int i = 0; i < n; i++) {
            int targetChar = target.charAt(i) - 'a';
            if (cnt[targetChar] > 0) {
                cnt[targetChar]--;
                if (canFormGreater(cnt, target, i + 1)) {
                    res.append(target.charAt(i));
                    continue;
                }
                cnt[targetChar]++;
            }
            for (int j = targetChar + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    res.append((char)('a' + j));
                    // 剩余位置按最小字典序填充
                    res.append(getMinString(cnt));
                    return res.toString();
                }
            }
            return "";
        }

        return "";
    }

    private boolean canFormGreater(int[] cnt, String target, int start) {
        String maxStr = getMaxString(cnt);
        String suffix = target.substring(start);
        return maxStr.compareTo(suffix) > 0;
    }

    private String getMaxString(int[] cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] > 0) {
                res.append(String.valueOf((char)('a' + i)).repeat(cnt[i]));
            }
        }
        return res.toString();
    }

    private String getMinString(int[] cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                res.append(String.valueOf((char)('a' + i)).repeat(cnt[i]));
            }
        }
        return res.toString();
    }
}
