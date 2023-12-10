/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function (matrix) {
    const m = matrix.length;
    const n = matrix[0].length;
    const res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = new Array(m).fill(0);
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            res[j][i] = matrix[i][j];
        }
    }
    return res;
};
