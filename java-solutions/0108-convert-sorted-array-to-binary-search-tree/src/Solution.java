/**
 * @author sichu
 * @date 2022/11/30
 **/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return inOrder(nums, 0, nums.length - 1);
    }

    private TreeNode inOrder(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inOrder(nums, left, mid - 1);
        root.right = inOrder(nums, mid + 1, right);
        return root;
    }
}
