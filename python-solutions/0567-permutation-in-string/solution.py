class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n = len(s1)
        m = len(s2)
        if n > m:
            return False
        cnt = [0] * 26
        for i in range(n):
            cnt[ord(s1[i]) - ord('a')] -= 1
        left = 0
        for right in range(m):
            x = ord(s2[right]) - ord('a')
            cnt[x] += 1
            while cnt[x] > 0:
                cnt[ord(s2[left]) - ord('a')] -= 1
                left += 1
            if right - left + 1 == n:
                return True
        return False
