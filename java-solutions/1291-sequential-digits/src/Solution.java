import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu
 * @date 2024/02/02
 **/
public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int num = i;
            for (int j = i + 1; j < 10; j++) {
                num = num * 10 + j;
                if (low <= num && num <= high) {
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
