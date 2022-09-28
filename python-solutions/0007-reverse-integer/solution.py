class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        INTEGER_MIN, INTEGER_MAX = -2 ** 31, 2 ** 31 - 1

        res = 0
        while x != 0:
            if res > INTEGER_MAX // 10 or res < INTEGER_MIN // 10 + 1:
                return 0
            digit = x % 10
            if x < 0 and digit > 0:
                digit -= 10
            x = (x - digit) // 10
            res = res * 10 + digit

        return res
