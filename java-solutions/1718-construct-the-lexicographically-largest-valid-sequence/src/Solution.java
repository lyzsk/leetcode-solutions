import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/11/18
 **/
public class Solution {
    Set<Integer> used;
    int[] arr;
    boolean flag;
    int[] res;

    public int[] constructDistancedSequence(int n) {
        int len = n * 2 - 1;
        used = new HashSet<>();
        res = new int[len];
        arr = new int[len];
        Arrays.fill(arr, -1);
        backtracking(n, len, 0);
        return res;
    }

    private void backtracking(int n, int len, int idx) {
        if (flag) {
            return;
        }
        if (len == idx) {
            flag = true;
            System.arraycopy(arr, 0, res, 0, 2 * n - 1);
            return;
        }
        if (arr[idx] != -1) {
            backtracking(n, len, idx + 1);
            return;
        }

        for (int i = n; i >= 1; i--) {
            if (used.contains(i)) {
                continue;
            }
            if (i == 1) {
                arr[idx] = i;
                used.add(i);
                backtracking(n, len, idx + 1);
                used.remove(i);
                arr[idx] = -1;

            } else {
                if (idx + i < len && arr[idx + i] == -1) {
                    arr[idx] = i;
                    arr[idx + i] = i;
                    used.add(i);
                    backtracking(n, len, idx + 1);
                    used.remove(i);
                    arr[idx] = -1;
                    arr[idx + i] = -1;
                }
            }
        }
    }
}
