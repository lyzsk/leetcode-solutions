/**
 * @param {number[]} nums
 * @return {number}
 */
var zeroFilledSubarray = function (nums) {
    let res = 0;
    let zeroCnt = 0;
    for (let num of nums) {
        if (num === 0) {
            ++zeroCnt;
            res += zeroCnt;
        } else {
            zeroCnt = 0;
        }
    }
    return res;
};
