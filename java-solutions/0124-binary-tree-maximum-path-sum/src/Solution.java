/**
 * @author sichu
 * @date 2022/10/07
 **/
public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int pathSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathSum);
        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
