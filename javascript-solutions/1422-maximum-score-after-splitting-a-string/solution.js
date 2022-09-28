/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function (s) {
    let ones = 0;
    for (let i = 0; i < s.length; i++) {
        ones += s[i] == "1" ? 1 : 0;
    }
    let zeros = 0;
    let res = 0;
    for (let i = 0; i < s.length - 1; i++) {
        if (s[i] == "0") {
            zeros += 1;
        } else {
            ones -= 1;
        }
        res = Math.max(res, zeros + ones);
    }
    return res;
};
