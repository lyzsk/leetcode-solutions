import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @date 2024/09/24
 **/
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (int x : arr1) {
            String s = String.valueOf(x);
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }
        for (int x : arr2) {
            String s = String.valueOf(x);
            for (int i = 1; i <= s.length(); i++) {
                if (!set.contains(s.substring(0, i))) {
                    break;
                }
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
