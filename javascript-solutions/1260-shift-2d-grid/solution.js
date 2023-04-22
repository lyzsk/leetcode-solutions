/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var shiftGrid = function (grid, k) {
    const m = grid.length;
    const n = grid[0].length;
    const res = [];
    for (let i = 0; i < m; i++) {
        const row = [];
        for (let j = 0; j < n; j++) {
            row.push(0);
        }
        res.push(row);
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const idx = (i * n + j + k) % (m * n);
            res[Math.floor(idx / n)].splice(idx % n, 1, grid[i][j]);
        }
    }
    return res;
};
