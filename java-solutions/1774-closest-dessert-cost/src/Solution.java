import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/12/04
 **/
public class Solution {
    private int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Arrays.stream(baseCosts).min().getAsInt();
        for (int basecost : baseCosts) {
            dfs(toppingCosts, target, basecost, 0);
        }
        return res;
    }

    private void dfs(int[] toppingCosts, int target, int curCost, int index) {
        if (Math.abs(res - target) < curCost - target) {
            return;
        } else if (Math.abs(res - target) >= Math.abs(curCost - target)) {
            if (Math.abs(res - target) > Math.abs(curCost - target)) {
                res = curCost;
            } else {
                res = Math.min(res, curCost);
            }
        }
        if (index == toppingCosts.length) {
            return;
        }
        dfs(toppingCosts, target, curCost + toppingCosts[index] * 2, index + 1);
        dfs(toppingCosts, target, curCost + toppingCosts[index], index + 1);
        dfs(toppingCosts, target, curCost, index + 1);
    }
}
