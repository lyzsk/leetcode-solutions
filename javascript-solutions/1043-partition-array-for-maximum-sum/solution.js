/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function (arr, k) {
    const n = arr.length;
    const dp = Array(n + 1).fill(0);
    let maxVal = 0;
    for (let i = 0; i < n; i++) {
        if (i < k) {
            maxVal = Math.max(maxVal, arr[i]);
            dp[i] = maxVal * (i + 1);
        } else {
            maxVal = 0;
            for (let j = i; j > i - k; j--) {
                maxVal = Math.max(maxVal, arr[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + maxVal * (i - j + 1));
            }
        }
    }
    return dp[n - 1];
};
