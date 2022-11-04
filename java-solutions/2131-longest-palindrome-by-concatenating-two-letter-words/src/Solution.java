/**
 * @author sichu
 * @date 2022/11/04
 **/
public class Solution {
    public int longestPalindrome(String[] words) {
        int[][] dp = new int[26][26];
        int middleLength = 0;
        for (String word : words) {
            dp[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int startLength = 0;
        for (int row = 0; row < 26; row++) {
            for (int col = 0; col < 26; col++) {
                if (row == col) {
                    if (dp[row][col] % 2 == 0) {
                        startLength += dp[row][col] * 2;
                    } else {
                        middleLength = 2;
                        startLength += 2 * (dp[row][col] - 1);
                    }
                } else {
                    if (dp[row][col] > 0 && dp[col][row] > 0) {
                        startLength += 4 * Math.min(dp[row][col], dp[col][row]);
                        dp[col][row] = 0;
                        dp[row][col] = 0;
                    }
                }
            }
        }
        return startLength + middleLength;
    }
}
