/**
 * @author sichu huang
 * @since 2025/01/02 18:37
 */
public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            prefixSums[i + 1] = prefixSums[i] + value;
        }
        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            res[i] = prefixSums[end + 1] - prefixSums[start];
        }
        return res;
    }

    private boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    private boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
