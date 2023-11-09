/**
 * @param {string} s
 * @return {number}
 */
var countHomogenous = function (s) {
    const mod = 1e9 + 7;
    let res = 0;
    let left = 0;
    for (let right = 0; right < s.length; right++) {
        if (s[left] == s[right]) {
            res += right - left + 1;
        } else {
            res += 1;
            left = right;
        }
    }
    return res % mod;
};
