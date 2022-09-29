import sys
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = sys.maxsize
        res = 0
        for price in prices:
            min_price = min(min_price, price)
            res = max(res, price - min_price)
        return res
