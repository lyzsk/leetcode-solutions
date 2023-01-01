/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function (pattern, s) {
    const ch2str = new Map();
    const str2ch = new Map();
    let i = 0;
    for (let p = 0; p < pattern.length; p++) {
        if (i >= s.length) {
            return false;
        }
        let j = i;
        while (j < s.length && s[j] !== " ") {
            ++j;
        }
        const ch = pattern[p];
        const str = s.substring(i, j);
        if (ch2str.has(ch) && ch2str.get(ch) !== str) {
            return false;
        }
        if (str2ch.has(str) && str2ch.get(str) !== ch) {
            return false;
        }
        ch2str.set(ch, str);
        str2ch.set(str, ch);
        i = j + 1;
    }
    return i >= s.length;
};
