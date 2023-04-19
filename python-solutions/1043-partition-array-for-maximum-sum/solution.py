from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        maxVal = 0
        for i in range(0, n):
            if i < k:
                maxVal = max(maxVal, arr[i])
                dp[i] = maxVal * (i + 1)
            else:
                maxVal = 0
                for j in range(i, i - k, -1):
                    maxVal = max(maxVal, arr[j])
                    dp[i] = max(dp[i], dp[j - 1] + maxVal * (i - j + 1))

        return dp[n - 1]
