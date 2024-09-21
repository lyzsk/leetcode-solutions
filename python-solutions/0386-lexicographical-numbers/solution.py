from typing import List


class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        res = [0] * n
        num = 1
        for i in range(n):
            res[i] = num
            if num * 10 <= n:
                num *= 10
            else:
                while num % 10 == 9 or num + 1 > n:
                    num //= 10
                num += 1
        return res