/**
 * @author sichu huang
 * @since 2026/01/13 17:39
 */
public class Solution {
    public double separateSquares(int[][] squares) {
        double maxY = 0;
        double minY = Integer.MAX_VALUE;
        double totalArea = 0;
        for (int[] sq : squares) {
            double topY = sq[1] + sq[2];
            maxY = Math.max(maxY, topY);
            minY = Math.min(minY, sq[1]);
            totalArea += (double)sq[2] * (double)sq[2];
        }
        double lo = minY;
        double hi = maxY;
        double precision = Math.pow(10, -5);
        while (lo < hi) {
            if (hi - lo < precision) {
                break;
            }
            double mid = lo + (hi - lo) / 2.0;
            double topArea = getTop(squares, mid);
            double bottomArea = totalArea - topArea;
            if (topArea <= bottomArea) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private double getTop(int[][] squares, double line) {
        double area = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double width = square[2];

            if (y >= line) {
                area += width * width;
            } else {
                if (y + width >= line) {
                    double actualHeight = y + width - line;
                    area += actualHeight * width;
                }
            }
        }

        return area;
    }
}
