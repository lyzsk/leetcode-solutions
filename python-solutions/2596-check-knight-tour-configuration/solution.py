from typing import List


class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        if grid[0][0] != 0:
            return False
        n = len(grid)
        indices = [[] for _ in range(n * n)]
        for i in range(n):
            for j in range(n):
                indices[grid[i][j]] = [i, j]
        for i in range(1, n * n, 1):
            dx = abs(indices[i][0] - indices[i - 1][0])
            dy = abs(indices[i][1] - indices[i - 1][1])
            if dx * dy != 2:
                return False
        return True
