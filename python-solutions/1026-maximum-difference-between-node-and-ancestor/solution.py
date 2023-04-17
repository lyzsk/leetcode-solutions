from typing import Optional

from treenode import TreeNode


class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        return Solution.dfs(self, root, root.val, root.val)

    def dfs(self, root: Optional[TreeNode], maxVal: int, minVal: int) -> int:
        if root is None:
            return 0
        maxDiff = max(abs(root.val - maxVal), abs(root.val - minVal))
        maxVal = max(maxVal, root.val)
        minVal = min(minVal, root.val)
        maxDiff = max(maxDiff, Solution.dfs(self, root.left, maxVal, minVal))
        maxDiff = max(maxDiff, Solution.dfs(self, root.right, maxVal, minVal))
        return maxDiff
