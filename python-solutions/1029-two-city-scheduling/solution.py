from typing import List


class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        diff = [0 for item in range(n)]
        res = 0
        for i in range(0, n):
            diff[i] = costs[i][1] - costs[i][0]
            res += costs[i][0]
        diff.sort()
        for i in range(0, n >> 1):
            res += diff[i]
        return res
