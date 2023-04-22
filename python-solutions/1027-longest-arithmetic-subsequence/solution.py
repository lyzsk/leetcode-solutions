from typing import List


class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        minv, maxv = min(nums), max(nums)
        diff = maxv - minv
        res = 1
        for i in range(-diff, diff + 1):
            dp = [-1 for j in range(maxv + 1)]
            for num in nums:
                prev = num - i
                if minv <= prev <= maxv and dp[prev] != -1:
                    dp[num] = max(dp[num], dp[prev] + 1)
                    res = max(res, dp[num])
                dp[num] = max(dp[num], 1)
        return res
