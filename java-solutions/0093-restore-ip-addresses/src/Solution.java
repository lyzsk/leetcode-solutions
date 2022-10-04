import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/04
 **/
public class Solution {
    private static void backtrack(List<String> res, Deque<String> path, String s, int startIndex, int residue) {
        if (startIndex == s.length()) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = startIndex; i < startIndex + 3; i++) {
            if (i >= s.length()) {
                break;
            }
            if (isIpSegment(s, startIndex, i)) {
                String currentIpSegment = s.substring(startIndex, i + 1);
                path.addLast(currentIpSegment);
                backtrack(res, path, s, i + 1, residue - 1);
                path.removeLast();
            }
        }
    }

    private static boolean isIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            ++left;
        }
        return res >= 0 && res <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        backtrack(res, path, s, 0, 4);
        return res;
    }
}
