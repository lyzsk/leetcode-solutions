from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        res = zeroCnt = 0

        for num in nums:
            if num == 0:
                zeroCnt += 1
                res += zeroCnt
            else:
                zeroCnt = 0

        return res
