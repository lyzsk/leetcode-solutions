/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] map = new int[1001];
        for (int[] boxType : boxTypes) {
            map[boxType[1]] += boxType[0];
        }
        int res = 0;
        for (int i = 1000; i >= 0 && truckSize > 0; i--) {
            if (map[i] == 0) {
                continue;
            }
            res += Math.min(truckSize, map[i]) * i;
            truckSize -= map[i];
        }
        return res;
    }
}
