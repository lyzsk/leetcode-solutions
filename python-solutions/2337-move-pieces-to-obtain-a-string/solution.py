class Solution:
    def canChange(self, start: str, target: str) -> bool:
        if start.replace("_", "") != target.replace("_", ""):
            return False
        i, j = 0, 0
        for i in range(len(start)):
            if start[i] == "_":
                continue
            while target[j] == '_':
                j += 1
            if (i < j and start[i] == 'L') or (i > j and start[i] == 'R'):
                return False
            j += 1
        return True
