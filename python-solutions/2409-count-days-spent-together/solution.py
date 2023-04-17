class Solution:
    DAYS = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        arriveAliceDays = Solution.getDays(self, arriveAlice)
        arriveBobDays = Solution.getDays(self, arriveBob)
        leaveAliceDays = Solution.getDays(self, leaveAlice)
        leaveBobDays = Solution.getDays(self, leaveBob)
        return max(0, min(leaveAliceDays, leaveBobDays) - max(arriveAliceDays, arriveBobDays) + 1)

    def getDays(self, date: str) -> int:
        days = 0
        month = int(date[0:2])
        day = int(date[3:5])

        for i in range(1, month):
            days += Solution.DAYS[i - 1]

        return days + day
