/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
    if (numRows < 2) {
        return s;
    }
    let rows = new Array(numRows).fill("");
    let col = 0;
    let flag = -1;
    for (let ch of s) {
        rows[col] += ch;
        if (col === 0 || col === numRows - 1) {
            flag = -flag;
        }
        col += flag;
    }
    let res = "";
    for (let row of rows) {
        res += row;
    }
    return res;
};
