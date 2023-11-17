from typing import List


class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        res = 0
        n = len(nums)
        nums.sort()
        for i in range(0, n >> 1):
            res = max(res, nums[i] + nums[n - 1 - i])
        return res
