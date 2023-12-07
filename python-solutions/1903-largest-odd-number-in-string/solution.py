class Solution:
    def largestOddNumber(self, num: str) -> str:
        n = len(num)
        if int(num[n - 1]) % 2 == 1:
            return num
        for i in range(n - 1, -1, -1):
            if int(num[i]) % 2 == 1:
                return num[:i + 1]
        return ""
