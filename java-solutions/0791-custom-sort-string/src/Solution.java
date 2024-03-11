/**
 * @author sichu huang
 * @date 2024/03/11
 **/
public class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++map[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < map[order.charAt(i) - 'a']; j++) {
                sb.append(order.charAt(i));
            }
            map[order.charAt(i) - 'a'] = 0;

        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map[i]; j++) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }
}