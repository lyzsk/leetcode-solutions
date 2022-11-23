/**
 * @author sichu
 * @date 2022/11/23
 **/
public class NumArray {
    private int[] presum;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.presum = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return presum[right];
        }
        return presum[right] - presum[left - 1];
    }
}
