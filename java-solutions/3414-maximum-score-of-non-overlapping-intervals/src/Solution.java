import java.util.*;

/**
 *
 * @author sichu huang
 * @since 2026/09/12
 */
public class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] indices = new List[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                indices[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            int l = arr[i][0], weight = arr[i][2], idx = arr[i][3];
            int k = binarySearch(arr, i, l);

            for (int j = 1; j < 5; j++) {
                long s1 = dp[i][j];
                long s2 = dp[k][j - 1] + weight;
                if (s1 > s2) {
                    dp[i + 1][j] = dp[i][j];
                    indices[i + 1][j] = new ArrayList<>(indices[i][j]);
                    continue;
                }

                List<Integer> newIndex = new ArrayList<>(indices[k][j - 1]);
                newIndex.add(idx);
                Collections.sort(newIndex);
                if (s1 == s2 && compareLists(indices[i][j], newIndex) < 0) {
                    newIndex = new ArrayList<>(indices[i][j]);
                }
                dp[i + 1][j] = s2;
                indices[i + 1][j] = newIndex;
            }
        }

        List<Integer> result = indices[n][4];
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private int binarySearch(int[][] arr, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
