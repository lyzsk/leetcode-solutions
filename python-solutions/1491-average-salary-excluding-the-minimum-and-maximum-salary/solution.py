from typing import List


class Solution:
    def average(self, salary: List[int]) -> float:
        minv = min(salary)
        maxv = max(salary)
        n = len(salary)
        return (sum(salary) - minv - maxv) / (n - 2)
