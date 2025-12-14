import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/12/13 16:14
 */
public class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] groups = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            groups[i] = new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty() && check(code[i], isActive[i])) {
                if (businessLine[i].equals("electronics")) {
                    groups[0].add(code[i]);
                } else if (businessLine[i].equals("grocery")) {
                    groups[1].add(code[i]);
                } else if (businessLine[i].equals("pharmacy")) {
                    groups[2].add(code[i]);
                } else if (businessLine[i].equals("restaurant")) {
                    groups[3].add(code[i]);
                }
            }
        }
        for (List<String> group : groups) {
            Collections.sort(group);
            res.addAll(group);
        }
        return res;
    }

    private boolean check(String code, boolean isActive) {
        for (char it : code.toCharArray()) {
            if (it != '_' && !Character.isLetterOrDigit(it)) {
                return false;
            }
        }
        return isActive;
    }
}
