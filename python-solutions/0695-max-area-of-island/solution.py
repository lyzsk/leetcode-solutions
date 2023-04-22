from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0

        def dfs(x: int, y: int) -> int:
            if x < 0 or y < 0 or x > m - 1 or y > n - 1 or grid[x][y] == 0:
                return 0
            grid[x][y] = 0
            res = 1
            res += dfs(x - 1, y)
            res += dfs(x + 1, y)
            res += dfs(x, y - 1)
            res += dfs(x, y + 1)
            return res

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res = max(res, dfs(i, j))
        return res
