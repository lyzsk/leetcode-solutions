class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        i = 0
        pre = 0
        while i < len(s):
            if s[i].isdigit():
                cur = 0
                while i < len(s) and s[i].isdigit():
                    cur = cur * 10 + int(s[i])
                    i += 1
                if cur <= pre:
                    return False
                pre = cur
            else:
                i += 1
        return True
