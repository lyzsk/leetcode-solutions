import sys
from typing import List


class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        n = len(books)
        dp = [sys.maxsize] * (n + 1)
        dp[0] = 0
        for i in range(0, n):
            maxHeight = 0
            curWidth = 0
            for j in range(i, -1, -1):
                curWidth += books[j][0]
                if curWidth > shelfWidth:
                    break
                maxHeight = max(maxHeight, books[j][1])
                dp[i + 1] = min(dp[i + 1], dp[j] + maxHeight)
        return dp[n]
