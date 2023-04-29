/**
 * @param {string} word
 * @return {boolean}
 */
var equalFrequency = function (word) {
    const freq = new Array(26).fill(0);
    for (let w of word) {
        ++freq[w.charCodeAt(0) - "a".charCodeAt(0)];
    }
    for (let i = 0; i < 26; i++) {
        if (freq[i] === 0) {
            continue;
        }
        --freq[i];
        const set = new Set();
        for (const f of freq) {
            if (f > 0) {
                set.add(f);
            }
        }
        if (set.size === 1) {
            return true;
        }
        ++freq[i];
    }
    return false;
};
