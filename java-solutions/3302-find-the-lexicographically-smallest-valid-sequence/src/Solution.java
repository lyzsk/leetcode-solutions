/**
 *
 * @author sichu huang
 * @since 2026/08/08 15:32
 */
public class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] startIndices = new int[m + 1];
        startIndices[m] = n;
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                startIndices[i] = j;
                j--;
            } else {
                startIndices[i] = j + 1;
            }
        }
        int[] indices = new int[n];
        boolean changed = false;
        for (int i = 0, j = 0; i < m; i++) {
            if (word1.charAt(i) == word2.charAt(j) || (!changed && startIndices[i + 1] <= j + 1)) {
                if (word1.charAt(i) != word2.charAt(j)) {
                    changed = true;
                }
                indices[j] = i;
                j++;
                if (j == n) {
                    return indices;
                }
            }
        }
        return new int[0];
    }
}
