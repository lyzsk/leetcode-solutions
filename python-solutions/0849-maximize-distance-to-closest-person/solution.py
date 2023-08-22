from typing import List


class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        res, left, n = 0, 0, len(seats)
        while (left < n and seats[left] == 0):
            left += 1
            res = max(res, left)
        while left < n:
            right = left + 1
            while right < n and seats[right] == 0:
                right += 1
            if right == n:
                res = max(res, right - left - 1)
            else:
                res = max(res, (right - left) >> 1)
            left = right
        return res
