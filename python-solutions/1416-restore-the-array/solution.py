class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        mod = int(1e9 + 7)
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            num = 0
            base = 1
            for j in range(i - 1, -1, -1):
                if i - j > 10:
                    break
                num += (ord(s[j]) - ord('0')) * base
                if num > k:
                    break
                if ord(s[j]) != ord('0'):
                    dp[i] += dp[j]
                    dp[i] %= mod
                base *= 10
        return dp[n]
