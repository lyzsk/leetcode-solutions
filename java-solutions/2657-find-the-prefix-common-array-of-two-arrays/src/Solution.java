/**
 * @author sichu
 * @date 2023/05/11
 **/
public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            ++cnt[A[i] - 1];
            for (int j = 0; j <= i; j++) {
                if (cnt[B[j] - 1] > 0) {
                    ++res[i];
                }
            }
        }
        return res;
    }
}
