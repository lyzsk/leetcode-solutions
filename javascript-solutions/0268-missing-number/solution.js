/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function (nums) {
    let res = 0;
    const n = nums.length;
    for (let i = 0; i < n; i++) {
        res ^= nums[i];
    }
    for (let i = 0; i <= n; i++) {
        res ^= i;
    }
    return res;
};
