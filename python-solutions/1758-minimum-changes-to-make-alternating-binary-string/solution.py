class Solution:
    def minOperations(self, s: str) -> int:
        cnt_zeros = 0
        cnt_ones = 0
        for i, ch in enumerate(s):
            if i % 2 == 0:
                if ch == '0':
                    cnt_ones += 1
                else:
                    cnt_zeros += 1
            else:
                if ch == '1':
                    cnt_ones += 1
                else:
                    cnt_zeros += 1
        return min(cnt_zeros, cnt_ones)
