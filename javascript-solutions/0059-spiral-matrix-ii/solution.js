/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function (n) {
    let num = 1;
    const matrix = new Array(n).fill(0).map(() => new Array(n).fill(0));
    let top = 0,
        bottom = n - 1,
        left = 0,
        right = n - 1;
    while (left <= right && top <= bottom) {
        for (let col = left; col <= right; col++) {
            matrix[top][col] = num++;
        }
        for (let row = top + 1; row <= bottom; row++) {
            matrix[row][right] = num++;
        }
        if (left < right && top < bottom) {
            for (let col = right - 1; col > left; col--) {
                matrix[bottom][col] = num++;
            }
            for (let row = bottom; row > top; row--) {
                matrix[row][left] = num++;
            }
        }
        ++top;
        --bottom;
        ++left;
        --right;
    }
    return matrix;
};
