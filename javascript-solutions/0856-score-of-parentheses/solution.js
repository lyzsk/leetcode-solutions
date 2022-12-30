/**
 * @param {string} s
 * @return {number}
 */
var scoreOfParentheses = function (s) {
    let bal = 0;
    let res = 0;
    for (let i = 0; i < s.length; i++) {
        bal += s[i] == "(" ? 1 : -1;
        if (s[i] == ")" && s[i - 1] == "(") {
            res += 1 << bal;
        }
    }
    return res;
};
