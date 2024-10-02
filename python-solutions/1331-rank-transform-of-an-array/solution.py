from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        n = len(arr)
        sorted_arr = sorted(arr)
        rank_map = {}
        res = [0] * n
        for item in sorted_arr:
            if item not in rank_map:
                rank_map[item] = len(rank_map) + 1
        for i in range(n):
            res[i] = rank_map[arr[i]]
        return res
