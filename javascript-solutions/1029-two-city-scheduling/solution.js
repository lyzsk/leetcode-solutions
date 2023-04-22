/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function (costs) {
    const n = costs.length;
    let diff = new Array(n).fill(0);
    let res = 0;
    for (let i = 0; i < n; i++) {
        diff[i] = costs[i][1] - costs[i][0];
        res += costs[i][0];
    }
    diff.sort((o1, o2) => {
        return o1 - o2;
    });
    for (let i = 0; i < n >> 1; i++) {
        res += diff[i];
    }
    return res;
};
