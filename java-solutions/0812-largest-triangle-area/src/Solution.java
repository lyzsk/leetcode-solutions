import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/09/28 10:29
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        int[][] convexHull = getConvexHull(points);
        int n = convexHull.length;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = i + 2; j + 1 < n; j++) {
                while (k + 1 < n) {
                    double curArea =
                        triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0],
                            convexHull[j][1], convexHull[k][0], convexHull[k][1]);
                    double nextArea =
                        triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0],
                            convexHull[j][1], convexHull[k + 1][0], convexHull[k + 1][1]);
                    if (curArea >= nextArea) {
                        break;
                    }
                    k++;
                }
                double area = triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0],
                    convexHull[j][1], convexHull[k][0], convexHull[k][1]);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    private int[][] getConvexHull(int[][] points) {
        int n = points.length;
        if (n < 4) {
            return points;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> hull = new ArrayList<int[]>();
        for (int[] point : points) {
            while (hull.size() > 1
                && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(point);
        }
        int m = hull.size();
        for (int i = n - 2; i >= 0; i--) {
            while (hull.size() > m
                && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }
        hull.remove(hull.size() - 1);
        m = hull.size();
        int[][] hullArr = new int[m][];
        for (int i = 0; i < m; i++) {
            hullArr[i] = hull.get(i);
        }
        return hullArr;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

    private int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}