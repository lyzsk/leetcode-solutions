class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        for ch in s:
            stk.append(ch)
            if ''.join(stk[-3:]) == "abc":
                stk[-3:] = []
        return len(stk) == 0
