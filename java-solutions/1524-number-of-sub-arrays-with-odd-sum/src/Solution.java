/**
 * @author sichu huang
 * @since 2025/02/25 16:53
 */
public class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1000000007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }
}
