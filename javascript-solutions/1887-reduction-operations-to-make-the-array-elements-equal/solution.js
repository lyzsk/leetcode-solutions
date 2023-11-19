/**
 * @param {number[]} nums
 * @return {number}
 */
var reductionOperations = function (nums) {
    const n = nums.length;
    nums.sort((a, b) => a - b);
    let res = 0;
    for (let i = n - 1; i > 0; i--) {
        if (nums[i - 1] !== nums[i]) {
            res += n - i;
        }
    }
    return res;
};
