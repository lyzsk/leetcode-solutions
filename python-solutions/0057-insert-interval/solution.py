from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        left, right = newInterval[0], newInterval[1]
        res = list()
        placed = False
        for interval in intervals:
            if interval[0] > right:
                if not placed:
                    res.append([left, right])
                    placed = True
                res.append([interval[0], interval[1]])
            elif interval[1] < left:
                res.append([interval[0], interval[1]])
            else:
                left = min(left, interval[0])
                right = max(right, interval[1])
        if not placed:
            res.append([left, right])
        return res
