/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    let presum = 0;
    let minpre = 0;
    let res = -Number.MAX_VALUE;
    nums.forEach((num) => {
        presum += num;
        res = Math.max(res, presum - minpre);
        minpre = Math.min(minpre, presum);
    });
    return res;
};
