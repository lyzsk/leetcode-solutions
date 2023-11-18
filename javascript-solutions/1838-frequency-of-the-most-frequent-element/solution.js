/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function (nums, k) {
    let res = 0;
    let sum = 0;
    nums.sort((a, b) => a - b);
    for (let left = 0, right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum + k < nums[right] * (right - left + 1)) {
            sum -= nums[left++];
        }
        res = Math.max(res, right - left + 1);
    }
    return res;
};
