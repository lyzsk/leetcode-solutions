import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/02/14
 **/
public class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversal(nums, root);
        int[] swapped = findSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void inorderTraversal(List<Integer> nums, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(nums, root.left);
        nums.add(root.val);
        inorderTraversal(nums, root.right);
    }

    public int[] findSwapped(List<Integer> nums) {
        int n = nums.size();
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                idx2 = i + 1;
                if (idx1 == -1) {
                    idx1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(idx1);
        int y = nums.get(idx2);
        return new int[] {x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}
