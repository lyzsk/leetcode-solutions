from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        res = []
        for interval in intervals:
            left = interval[0]
            right = interval[1]
            if not res or left > res[-1][1]:
                res.append([left, right])
            else:
                res[-1][1] = max(res[-1][1], right)
        return res
