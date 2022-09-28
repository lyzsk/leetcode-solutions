package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class stack.TreeNode {
 * int val;
 * stack.TreeNode left;
 * stack.TreeNode right;
 * stack.TreeNode() {}
 * stack.TreeNode(int val) { this.val = val; }
 * stack.TreeNode(int val, stack.TreeNode left, stack.TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * @author sichu
 * @date 2022/08/19
 **/
public class Solution {
    /**
     * 比如[3,1,2,4]:
     * 3入栈 栈里有[3],
     * 1<3 栈顶的3的右孩子是1 -> 3.right=1 -> 1入栈 栈里有[3,1],
     * 2>1 栈顶的1是2的左孩子且弹出1 -> 2.left=1 栈里有[3] -> 2<3 栈顶的3的右孩子是2 -> 3.right=2 -> 2入栈 栈里有[3,2],
     * 4>2 栈顶的2是4的左孩子且弹出2 -> 4.left=2 -> 4>3 栈顶的3是4的左孩子且弹出3 4.left = 3 -> 4入栈 栈里有[4],
     * 返回4.left=3, 3.right=2, 2.left=1 -> [4, 3, null, null, 2, 1]
     *
     * @param nums given nums
     * @return tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!stack.isEmpty() && curr.val > stack.peekFirst().val) {
                curr.left = stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                stack.peekFirst().right = curr;
            }
            stack.addFirst(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
