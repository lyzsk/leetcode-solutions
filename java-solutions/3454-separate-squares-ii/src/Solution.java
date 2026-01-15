import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu huang
 * @since 2026/01/14 17:59
 */
public class Solution {
    public double separateSquares(int[][] squares) {
        List<Event> sweepEvents = new ArrayList<>();
        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            sweepEvents.add(new Event(y, 1, x, x + l));
            sweepEvents.add(new Event(y + l, -1, x, x + l));
        }
        Collections.sort(sweepEvents);
        List<Interval> activeIntervals = new ArrayList<>();
        List<double[]> processedStrips = new ArrayList<>();
        double totalArea = 0;
        int prevY = sweepEvents.get(0).y;
        for (Event event : sweepEvents) {
            if (event.y > prevY) {
                double unionWidth = getUnionWidth(activeIntervals);
                double height = (double)event.y - prevY;

                if (unionWidth > 0) {
                    processedStrips.add(new double[] {prevY, height, unionWidth});
                    totalArea += height * unionWidth;
                }
            }

            Interval currentInterval = new Interval(event.xStart, event.xEnd);
            if (event.type == 1) {
                activeIntervals.add(currentInterval);
            } else {
                activeIntervals.remove(currentInterval);
            }

            prevY = event.y;
        }

        double targetArea = totalArea / 2.0;
        double accumulatedArea = 0;

        for (double[] strip : processedStrips) {
            double bottomY = strip[0];
            double height = strip[1];
            double width = strip[2];
            double stripArea = height * width;

            if (accumulatedArea + stripArea >= targetArea) {
                double missingArea = targetArea - accumulatedArea;
                return bottomY + (missingArea / width);
            }
            accumulatedArea += stripArea;
        }

        return 0.0;
    }

    private double getUnionWidth(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        List<Interval> sorted = new ArrayList<>(intervals);
        Collections.sort(sorted);

        double unionLength = 0;
        double currentEnd = -1e18;

        for (Interval iv : sorted) {
            if (iv.start >= currentEnd) {
                unionLength += (iv.end - iv.start);
                currentEnd = iv.end;
            } else if (iv.end > currentEnd) {
                unionLength += (iv.end - currentEnd);
                currentEnd = iv.end;
            }
        }
        return unionLength;
    }

    private static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Interval interval = (Interval)o;
            return start == interval.start && end == interval.end;
        }
    }

    private static class Event implements Comparable<Event> {
        int y;
        int type;
        int xStart, xEnd;

        Event(int y, int type, int xStart, int xEnd) {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.y, other.y);
        }
    }
}
