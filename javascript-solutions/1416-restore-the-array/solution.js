/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var numberOfArrays = function (s, k) {
    const mod = 1e9 + 7;
    const n = s.length;
    const dp = new Array(n + 1).fill(0);
    dp[0] = 1;
    for (let i = 1; i <= n; i++) {
        let num = 0;
        let base = 1;
        for (let j = i - 1; j >= 0 && i - j <= 10; j--) {
            num += (s.charCodeAt(j) - "0".charCodeAt(0)) * base;
            if (num > k) {
                break;
            }
            if (s.charCodeAt(j) != "0".charCodeAt(0)) {
                dp[i] += dp[j];
                dp[i] %= mod;
            }
            base *= 10;
        }
    }
    return dp[n];
};
