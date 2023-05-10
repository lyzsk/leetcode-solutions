from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = list()
        if not matrix or not matrix[0]:
            return res
        top, bottom, left, right = 0, len(matrix) - 1, 0, len(matrix[0]) - 1
        while left <= right and top <= bottom:
            for col in range(left, right + 1):
                res.append(matrix[top][col])
            for row in range(top + 1, bottom + 1):
                res.append(matrix[row][right])
            if left < right and top < bottom:
                for col in range(right - 1, left, -1):
                    res.append(matrix[bottom][col])
                for row in range(bottom, top, -1):
                    res.append(matrix[row][left])
            left += 1
            right -= 1
            top += 1
            bottom -= 1
        return res
