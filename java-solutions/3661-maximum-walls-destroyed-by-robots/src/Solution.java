import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/04/03 15:34
 */
public class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] num = new int[n];
        Map<Integer, Integer> robotsToDistance = new HashMap<>();

        for (int i = 0; i < n; i++) {
            robotsToDistance.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        int m = walls.length;
        int rightPtr = 0, leftPtr = 0, curPtr = 0, robotPtr = 0;

        for (int i = 0; i < n; i++) {
            while (rightPtr < m && walls[rightPtr] <= robots[i]) {
                rightPtr++;
            }
            int pos1 = rightPtr;

            while (curPtr < m && walls[curPtr] < robots[i]) {
                curPtr++;
            }
            int pos2 = curPtr;

            int leftBound = robots[i] - robotsToDistance.get(robots[i]);
            if (i >= 1) {
                leftBound =
                    Math.max(robots[i] - robotsToDistance.get(robots[i]), robots[i - 1] + 1);
            }
            while (leftPtr < m && walls[leftPtr] < leftBound) {
                leftPtr++;
            }
            int leftPos = leftPtr;
            left[i] = pos1 - leftPos;

            int rightBound = robots[i] + robotsToDistance.get(robots[i]);
            if (i < n - 1) {
                rightBound =
                    Math.min(robots[i] + robotsToDistance.get(robots[i]), robots[i + 1] - 1);
            }
            while (rightPtr < m && walls[rightPtr] <= rightBound) {
                rightPtr++;
            }
            int rightPos = rightPtr;
            right[i] = rightPos - pos2;

            if (i == 0) {
                continue;
            }
            while (robotPtr < m && walls[robotPtr] < robots[i - 1]) {
                robotPtr++;
            }
            int pos3 = robotPtr;
            num[i] = pos1 - pos3;
        }

        int subLeft = left[0], subRight = right[0];
        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(subLeft + left[i],
                subRight - right[i - 1] + Math.min(left[i] + right[i - 1], num[i]));
            int currentRight = Math.max(subLeft + right[i], subRight + right[i]);
            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);
    }
}
