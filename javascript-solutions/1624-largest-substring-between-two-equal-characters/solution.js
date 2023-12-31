/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function (s) {
    const n = s.length;
    let res = -1;
    for (let left = 0; left < n; left++) {
        for (let right = left + 1; right < n; right++) {
            if (s[left] === s[right]) {
                res = Math.max(res, right - left - 1);
            }
        }
    }
    return res;
};
