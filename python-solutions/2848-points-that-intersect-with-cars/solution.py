from typing import List


class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        nums.sort(key=lambda o: o[0])
        n = len(nums)
        merged = []
        for num in nums:
            left = num[0]
            right = num[1]
            if not merged or left > merged[-1][1]:
                merged.append([left, right])
            else:
                merged[-1][1] = max(merged[-1][1], right)
        res = 0
        for merge in merged:
            res += (merge[1] - merge[0] + 1)
        return res
