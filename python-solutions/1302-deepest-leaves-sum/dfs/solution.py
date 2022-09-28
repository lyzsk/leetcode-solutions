from typing import Optional

from treenode import TreeNode


class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        maxLevel = -1
        sum = 0

        def dfs(node: Optional[TreeNode], level: int) -> None:
            if node is None:
                return
            nonlocal maxLevel, sum
            if level > maxLevel:
                maxLevel, sum = level, node.val
            elif level == maxLevel:
                sum += node.val
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)

        dfs(root, 0)
        return sum
   