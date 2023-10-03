from typing import List


class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        curMaxij = 0
        curMax = 0
        res = 0
        for num in nums:
            res = max(res, curMaxij * num)
            curMaxij = max(curMaxij, curMax - num)
            curMax = max(curMax, num)
        return res
