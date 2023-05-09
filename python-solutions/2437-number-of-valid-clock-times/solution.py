class Solution:
    def countTime(self, time: str) -> int:
        hrCnt = 0
        minCnt = 0
        for i in range(24):
            fstHr = i // 10
            secHr = i % 10
            if (time[0] == '?' or int(time[0]) == fstHr) and (time[1] == '?' or int(time[1]) == secHr):
                hrCnt += 1
        for i in range(60):
            fstMin = i // 10
            secMin = i % 10
            if (time[3] == '?' or int(time[3]) == fstMin) and (time[4] == '?' or int(time[4]) == secMin):
                minCnt += 1
        return hrCnt * minCnt
