class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        if sx == fx and sy == fy:
            return t == 0 or t >= 2
        minx = min(sx, fx)
        miny = min(sy, fy)
        maxx = max(sx, fx)
        maxy = max(sy, fy)
        return minx + t >= maxx and miny + t >= maxy
