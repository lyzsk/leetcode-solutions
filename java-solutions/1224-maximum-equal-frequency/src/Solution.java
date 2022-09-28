/**
 * @author sichu
 * @date 2022/08/18
 **/
public class Solution {
    /**
     * freq[] 记录i出现的次数
     * count[] 记录出现次数为i的数有几个
     * max 记录最大的freq[i]
     * 情况1: nums[]中所有数都只出现了一次, 此时删除任意一个满足题意, 即maxFreq == 1
     * 例子1: [1, 2, 3, 5, 7, 9, 20]
     * 情况2: nums[]中有一个数只出现了一次, 其他数都出现了maxFreq次, 此时也只需删除出现次数为1的数,
     * 即count[maxFreq] * maxFreq + 1 = i + 1
     * 例子2: [2, 2, 3, 3, 4, 4, 5]
     * 情况3: nums[]中只有一个数出现了maxFreq次, 其他数都出现了maxFreq - 1次,
     * 此时只需要删除一个出现次数为maxFreq次的数就满足题意,
     * 即(count[maxFreq - 1] + 1) * (maxFreq - 1) + 1 == i + 1
     * 例子3: [1, 1, 1, 2, 2, 3, 3]
     *
     * @param nums 输入正整数数组
     * @return res 对于长度为res的nums前缀, 删除一个元素后, 剩下的每个数字出现次数相同
     */
    public int maxEqualFreq(int[] nums) {
        int[] freq = new int[100001];
        int[] count = new int[100001];
        int maxFreq = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int curFreq = ++freq[nums[i]];
            ++count[curFreq];
            --count[curFreq - 1];
            maxFreq = Math.max(maxFreq, curFreq);
            if (maxFreq == 1) {
                res = i + 1;
            }
            if (count[maxFreq] * maxFreq + 1 == i + 1) {
                res = i + 1;
            }
            if ((count[maxFreq - 1] + 1) * (maxFreq - 1) + 1 == i + 1) {
                res = i + 1;
            }
        }
        return res;
    }
}
