/**
 * @author sichu
 * @date 2022/11/20
 **/
public class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int n = fruits.length;
        if (n == 1) {
            return 1;
        }
        int res = 0;
        int[] cnt = new int[n];
        int type = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (cnt[fruits[right]] == 0) {
                ++type;
                while (type > 2) {
                    --cnt[fruits[left]];
                    if (cnt[fruits[left]] == 0) {
                        --type;
                    }
                    ++left;
                }
            }
            ++cnt[fruits[right]];
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
