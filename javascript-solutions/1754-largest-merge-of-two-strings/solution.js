/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var largestMerge = function (word1, word2) {
    let merge = "";
    let i = 0;
    let j = 0;
    while (i < word1.length || j < word2.length) {
        if (i < word1.length && word1.slice(i) > word2.slice(j)) {
            merge += word1[i++];
        } else {
            merge += word2[j++];
        }
    }
    return merge;
};
