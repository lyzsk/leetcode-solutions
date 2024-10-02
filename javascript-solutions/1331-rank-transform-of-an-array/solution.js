/**
 * @param {number[]} arr
 * @return {number[]}
 */
var arrayRankTransform = function (arr) {
    const n = arr.length;
    const sortedArr = [...arr].sort((o1, o2) => o1 - o2);
    const rankMap = new Map();
    const res = new Array(n);
    for (const item of sortedArr) {
        if (!rankMap.has(item)) {
            rankMap.set(item, rankMap.size + 1);
        }
    }

    for (let i = 0; i < n; i++) {
        res[i] = rankMap.get(arr[i]);
    }

    return res;
};
