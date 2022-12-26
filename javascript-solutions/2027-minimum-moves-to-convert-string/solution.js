/**
 * @param {string} s
 * @return {number}
 */
var minimumMoves = function (s) {
    let res = 0;
    let i = -1;
    for (let j = 0; j < s.length; j++) {
        if (s[j] === "X" && j > i) {
            ++res;
            i = j + 2;
        }
    }
    return res;
};
