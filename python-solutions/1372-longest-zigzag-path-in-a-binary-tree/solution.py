from typing import Optional

from treenode import TreeNode


class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        res = 0

        def dfs(root: Optional[TreeNode], leftMax: int, rightMax: int):
            nonlocal res
            res = max(res, leftMax, rightMax)
            if root.left:
                dfs(root.left, rightMax + 1, 0)
            if root.right:
                dfs(root.right, 0, leftMax + 1)

        dfs(root, 0, 0)
        return res
