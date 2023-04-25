/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function (names, heights) {
    const n = names.length;
    const indices = new Array(n);
    for (let i = 0; i < n; i++) {
        indices[i] = i;
    }
    indices.sort((o1, o2) => heights[o2] - heights[o1]);
    const res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = names[indices[i]];
    }
    return res;
};
