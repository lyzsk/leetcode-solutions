from typing import List


class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        maxLeft = max(left, default=0)
        minRight = min(right, default=n)
        return max(maxLeft, n - minRight)
