from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        num = 1
        matrix = [[0] * n for _ in range(n)]
        top, bottom, left, right = 0, len(matrix) - 1, 0, len(matrix[0]) - 1
        while left <= right and top <= bottom:
            for col in range(left, right + 1):
                matrix[top][col] = num
                num += 1
            for row in range(top + 1, bottom + 1):
                matrix[row][right] = num
                num += 1
            if left < right and top < bottom:
                for col in range(right - 1, left, -1):
                    matrix[bottom][col] = num
                    num += 1
                for row in range(bottom, top, -1):
                    matrix[row][left] = num
                    num += 1
            top += 1
            bottom -= 1
            left += 1
            right -= 1
        return matrix
