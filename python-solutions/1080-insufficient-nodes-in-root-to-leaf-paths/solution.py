from typing import Optional

from treenode import TreeNode


class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def check(root, sum, limit):
            if root is None:
                return False
            if root.left is None and root.right is None:
                return root.val + sum >= limit
            leftFlag = check(root.left, sum + root.val, limit)
            rightFlag = check(root.right, sum + root.val, limit)
            if not leftFlag:
                root.left = None
            if not rightFlag:
                root.right = None
            return leftFlag or rightFlag

        flag = check(root, 0, limit)
        return root if flag else None
