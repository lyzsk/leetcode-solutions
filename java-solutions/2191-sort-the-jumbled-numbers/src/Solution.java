import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/07/24
 **/
public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedNums = new int[n][];
        for (int i = 0; i < n; i++) {
            mappedNums[i] = new int[] {getMappingNum(nums[i], mapping), i};
        }
        Arrays.sort(mappedNums, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            int index = mappedNums[i][1];
            sorted[i] = nums[index];
        }
        return sorted;
    }

    private int getMappingNum(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        int mappedNum = 0;
        int unit = 1;
        while (num > 0) {
            int digit = num % 10;
            mappedNum += mapping[digit] * unit;
            num /= 10;
            unit *= 10;
        }
        return mappedNum;
    }

}
