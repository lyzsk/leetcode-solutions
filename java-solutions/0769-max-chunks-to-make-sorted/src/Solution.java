/**
 * @author sichu
 * @date 2022/10/13
 **/
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1]);
            if (arr[i] == i) {
                ++res;
            }
        }
        return res;
    }
}
