/**
 *
 * @author sichu huang
 * @since 2026/04/04 14:40
 */
public class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows && i + j < cols; i++) {
                int curIdx = i * cols + (i + j);
                sb.append(encodedText.charAt(curIdx));
            }
        }
        int idx = sb.length() - 1;
        while (idx > 0 && sb.charAt(idx) == ' ')
            idx--;
        return sb.substring(0, idx + 1);
    }
}
