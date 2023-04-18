/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function (s, t) {
    let res = 0;
    for (const ch of s) {
        res ^= ch.charCodeAt();
    }
    for (const ch of t) {
        res ^= ch.charCodeAt();
    }
    return String.fromCharCode(res);
};
