class Solution:
    def lastSubstring(self, s: str) -> str:
        i, j, k, n = 0, 1, 0, len(s)
        while j + k < n:
            diff = ord(s[i + k]) - ord(s[j + k])
            if diff == 0:
                k += 1
            elif diff < 0:
                i += k + 1
                k = 0
                if i >= j:
                    j = i + 1
            else:
                j += k + 1
                k = 0
        return s[i:]
