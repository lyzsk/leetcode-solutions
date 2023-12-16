/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    const lens = s.length;
    const lent = t.length;
    if (lens != lent) {
        return false;
    }
    const freq = Array(26).fill(0);
    for (let i = 0; i < lens; i++) {
        freq[s.charCodeAt(i) - "a".charCodeAt(0)]++;
        freq[t.charCodeAt(i) - "a".charCodeAt(0)]--;
    }
    return freq.every((cnt) => cnt === 0);
};
