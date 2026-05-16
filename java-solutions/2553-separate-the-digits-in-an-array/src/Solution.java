import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/05/12 19:04
 */
public class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {

                list.add(ch - '0');
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
