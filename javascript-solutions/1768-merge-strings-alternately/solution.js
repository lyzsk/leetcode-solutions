/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function (word1, word2) {
    const m = word1.length,
        n = word2.length;
    let p1 = 0,
        p2 = 0;
    let res = [];
    while (p1 < m || p2 < n) {
        if (p1 < m) {
            res.push(word1[p1++]);
        }
        if (p2 < n) {
            res.push(word2[p2++]);
        }
    }
    return res.join("");
};
