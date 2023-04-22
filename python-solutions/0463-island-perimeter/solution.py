from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        res = 0

        def dfs(x: int, y: int) -> int:
            if x < 0 or y < 0 or x > len(grid) - 1 or y > len(grid[0]) - 1 or grid[x][y] == 0:
                return 1
            if grid[x][y] == 2:
                return 0
            grid[x][y] = 2
            res = 0
            res += dfs(x - 1, y)
            res += dfs(x + 1, y)
            res += dfs(x, y - 1)
            res += dfs(x, y + 1)
            return res

        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 1:
                    res += dfs(i, j)
        return res
