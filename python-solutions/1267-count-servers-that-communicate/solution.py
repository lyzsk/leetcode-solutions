from typing import List


class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        r, c = len(grid), len(grid[0])
        rowCnt, colCnt = [0] * r, [0] * c
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    rowCnt[i] += 1
                    colCnt[j] += 1
        res = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1 and (rowCnt[i] > 1 or colCnt[j] > 1):
                    res += 1
        return res
