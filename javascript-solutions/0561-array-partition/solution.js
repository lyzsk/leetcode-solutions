/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function (nums) {
    nums.sort((o1, o2) => o1 - o2);
    let res = 0;
    for (let i = 0; i < nums.length; i += 2) {
        res += nums[i];
    }
    return res;
};
