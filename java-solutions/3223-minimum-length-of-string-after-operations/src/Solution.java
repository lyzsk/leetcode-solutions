/**
 * @author sichu huang
 * @since 2025/01/13 17:45
 */
public class Solution {
    public int minimumLength(String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        for (int frequency : charFrequency) {
            if (frequency == 0) {
                continue;
            }
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }
}
