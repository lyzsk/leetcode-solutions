from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        merged = []
        for interval in intervals:
            left = interval[0]
            right = interval[1]
            if not merged or left > merged[-1][1]:
                merged.append([left, right])
            else:
                merged[-1][1] = max(merged[-1][1], right)
        return merged
