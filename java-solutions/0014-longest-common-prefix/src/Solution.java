/**
 * @author sichu
 * @date 2022/10/22
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
                if (res.length() == 0) {
                    return "";
                }
            }
        }
        return res;
    }
}
