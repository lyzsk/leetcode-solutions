class Solution:
    def reorganizeString(self, s: str) -> str:
        arr = list(s)
        n = len(arr)
        cnt = [0] * 26
        for i in range(n):
            cnt[ord(arr[i]) - ord('a')] += 1
        maxIdx = 0
        for i in range(26):
            if cnt[i] > cnt[maxIdx]:
                maxIdx = i
        if cnt[maxIdx] > (n + 1) >> 1:
            return ""
        res = [""] * n
        i = 0
        while cnt[maxIdx] > 0:
            res[i] = chr(ord('a') + maxIdx)
            i += 2
            cnt[maxIdx] -= 1
        for j in range(26):
            while cnt[j] > 0:
                if i >= n:
                    i = 1
                res[i] = chr(ord('a') + j)
                i += 2
                cnt[j] -= 1
        return "".join(res)
