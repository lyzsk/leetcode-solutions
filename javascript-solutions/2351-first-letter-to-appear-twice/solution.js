/**
 * @param {string} s
 * @return {character}
 */
var repeatedCharacter = function (s) {
    let set = new Set();
    for (let i = 0; i < s.length; i++) {
        if (set.has(s[i])) {
            return s[i];
        }
        set.add(s[i]);
    }
    return " ";
};
