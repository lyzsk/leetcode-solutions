from typing import List


class Solution:
    def minSizeSubarray(self, nums: List[int], target: int) -> int:
        total = 0
        for num in nums:
            total += num
        n = len(nums)
        res = float('inf')
        left = 0
        sumv = 0
        for right in range(0, 2 * n):
            sumv += nums[right % n]
            while sumv > target % total:
                sumv -= nums[left % n]
                left += 1
            if sumv == target % total:
                res = min(res, right - left + 1)
        return -1 if res == float('inf') else res + (target // total) * n
