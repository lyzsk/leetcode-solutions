/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function (words) {
    let res = 0;
    const map = new Map();
    words.sort((o1, o2) => o1.length - o2.length);
    for (const word of words) {
        map.set(word, 1);
        for (let i = 0; i < word.length; i++) {
            const subseq = word.substring(0, i) + word.substring(i + 1);
            if (map.has(subseq)) {
                map.set(word, Math.max(map.get(word), map.get(subseq) + 1));
            }
        }
        res = Math.max(res, map.get(word));
    }
    return res;
};
