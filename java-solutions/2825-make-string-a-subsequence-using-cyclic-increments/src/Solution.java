/**
 * @author sichu huang
 * @since 2024/12/04 17:21
 */
public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetIdx = 0, targetLen = str2.length();
        for (char currChar : str1.toCharArray()) {
            if (targetIdx < targetLen && (str2.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }
}
