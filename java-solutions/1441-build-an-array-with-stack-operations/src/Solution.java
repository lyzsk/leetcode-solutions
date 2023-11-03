import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/11/03
 **/
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int cur = 1;
        int idx = 0;
        while (cur <= n && idx < target.length) {
            int num = target[idx];
            if (num == cur) {
                res.add("Push");
                ++cur;
                ++idx;
            } else {
                res.add("Push");
                res.add("Pop");
                ++cur;
            }
        }
        return res;
    }
}
