import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/10/04
 **/
public class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int len = skill.length;
        int sum = skill[0] + skill[len - 1];
        long res = (long)skill[0] * skill[len - 1];
        for (int low = 1, high = len - 2; low < high; low++, high--) {
            if ((skill[low] + skill[high]) != sum) {
                return -1;
            } else {
                res += (long)skill[low] * skill[high];
            }
        }
        return res;
    }
}
