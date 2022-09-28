from collections import deque
from typing import Optional

from treenode import TreeNode


class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        queue, sum = deque([root]), 0
        while queue:
            cur = 0
            for _ in range(len(queue)):
                node = queue.popleft()
                cur += node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            sum = cur
        return sum
