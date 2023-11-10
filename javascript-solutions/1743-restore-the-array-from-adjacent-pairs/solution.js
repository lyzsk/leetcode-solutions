/**
 * @param {number[][]} adjacentPairs
 * @return {number[]}
 */
var restoreArray = function (adjacentPairs) {
    const graph = new Map();
    for (const [u, v] of adjacentPairs) {
        if (!graph.has(u)) {
            graph.set(u, []);
        }
        if (!graph.has(v)) {
            graph.set(v, []);
        }
        graph.get(u).push(v);
        graph.get(v).push(u);
    }
    let res = [];
    for (const [node, neighbors] of graph.entries()) {
        if (neighbors.length === 1) {
            res = [node, neighbors[0]];
            break;
        }
    }
    while (res.length < adjacentPairs.length + 1) {
        const [last, prev] = [res[res.length - 1], res[res.length - 2]];
        const candidates = graph.get(last);
        const nextElement =
            candidates[0] !== prev ? candidates[0] : candidates[1];
        res.push(nextElement);
    }
    return res;
};
