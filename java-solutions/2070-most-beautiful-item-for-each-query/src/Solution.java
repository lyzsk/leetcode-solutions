import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/11/12 18:01
 */
public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int[] arr = new int[n];
        Arrays.sort(items, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        arr[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i - 1], items[i][1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = n - 1;
            if (items[r][0] <= queries[i]) {
                res[i] = arr[r];
                continue;
            }
            if (items[l][0] > queries[i]) {
                continue;
            }
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (items[mid][0] <= queries[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            res[i] = arr[l - 1];
        }
        return res;
    }
}
