class Solution:
    def equalFrequency(self, word: str) -> bool:
        freq = [0] * 26
        for w in word:
            freq[ord(w) - ord('a')] += 1
        for i in range(26):
            if freq[i] == 0:
                continue
            freq[i] -= 1
            f = set(w for w in freq if w > 0)
            if len(f) == 1:
                return True
            freq[i] += 1
        return False
