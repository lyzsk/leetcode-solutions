from typing import List


class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        res = 0
        sum = 0
        nums.sort()
        left = 0
        for right in range(0, len(nums)):
            sum += nums[right]
            while sum + k < nums[right] * (right - left + 1):
                sum -= nums[left]
                left += 1
            res = max(res, right - left + 1)
        return res
