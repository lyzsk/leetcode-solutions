/**
 * @author sichu
 * @date 2022/12/03
 **/
public class Solution {
    int min;
    int max;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(n, 1, firstPlayer, secondPlayer);
        return new int[] {min, max};
    }

    private void dfs(int n, int round, int first, int second) {
        if (first + second == n + 1) {
            min = Math.min(min, round);
            max = Math.max(max, round);
            return;
        }

        //reverse the order for easy count
        if (n - second < first - 1) {
            dfs(n, round, n + 1 - second, n + 1 - first);
            return;
        }

        int mid = n / 2 + 1;
        //the scope of firstplayer
        int lmin = 0;
        int lmax = 0;

        //the scope of distance between first and second player
        int rmin = 0;
        int rmax = 0;

        if (second < mid) {
            lmin = 1;
            lmax = first;
            rmin = 1;
            rmax = second - first;
        } else {
            lmin = 1;
            lmax = first;
            rmin = second - mid + 1;
            int k = n % 2 == 1 ? second - mid - 1 : second - mid;
            rmax = second - first - 1 - k;
        }

        for (int i = lmin; i <= lmax; i++) {
            for (int j = rmin; j <= rmax; j++) {
                dfs((n + 1) / 2, round + 1, i, i + j);
            }
        }
    }
}
