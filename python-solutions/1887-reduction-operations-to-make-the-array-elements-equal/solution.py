from typing import List


class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        res = 0
        for i in range(n - 1, 0, -1):
            if nums[i - 1] != nums[i]:
                res += n - i
        return res
