import java.util.List;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new Boolean[s.length()];
        return helper(s, wordDict, 0);
    }

    private boolean helper(String s, List<String> wordDict, int idx) {
        if (idx == s.length()) {
            return true;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        for (String word : wordDict) {
            if (s.startsWith(word, idx) && helper(s, wordDict, idx + word.length())) {
                memo[idx] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }

    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     boolean[] dp = new boolean[s.length() + 1];
    //     dp[0] = true;
    //     for (int i = 1; i <= s.length(); i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (dp[j] && set.contains(s.substring(j, i))) {
    //                 dp[i] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return dp[s.length()];
    // }
}
