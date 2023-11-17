/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function (nums) {
    let res = 0;
    const n = nums.length;
    nums.sort((a, b) => a - b);
    for (let i = 0; i < n >> 1; i++) {
        res = Math.max(res, nums[i] + nums[n - 1 - i]);
    }
    return res;
};
