import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/16
 **/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }
}
