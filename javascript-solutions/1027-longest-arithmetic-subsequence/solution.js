/**
 * @param {number[]} nums
 * @return {number}
 */
var longestArithSeqLength = function (nums) {
    const minv = _.min(nums);
    const maxv = _.max(nums);
    const diff = maxv - minv;
    let res = 1;
    for (let i = -diff; i <= diff; i++) {
        const dp = new Array(maxv + 1).fill(-1);
        for (const num of nums) {
            let prev = num - i;
            if (prev >= minv && prev <= maxv && dp[prev] != -1) {
                dp[num] = Math.max(dp[num], dp[prev] + 1);
                res = Math.max(res, dp[num]);
            }
            dp[num] = Math.max(dp[num], 1);
        }
    }
    return res;
};
