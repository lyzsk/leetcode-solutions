/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        // int res = 0;
        // Map<Integer, Integer> map = new HashMap<>(16);
        // for (int i = lowLimit; i <= highLimit; i++) {
        //     int number = 0;
        //     int temp = i;
        //     while (temp > 0) {
        //         int digit = temp % 10;
        //         number += digit;
        //         temp /= 10;
        //     }
        //     map.put(number, map.getOrDefault(number, 0) + 1);
        // }
        // for (int key : map.keySet()) {
        //     res = Math.max(res, map.get(key));
        // }
        // return res;
        int res = 0;
        int[] map = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int number = 0;
            int temp = i;
            while (temp > 0) {
                int digit = temp % 10;
                number += digit;
                temp /= 10;
            }
            map[number] += 1;
            res = Math.max(res, map[number]);
        }
        return res;
        // return Arrays.stream(map).max().getAsInt();
    }
}
