/**
 * @param {string} s
 * @return {string}
 */
var lastSubstring = function (s) {
    const n = s.length;
    let i = 0;
    for (let j = 1, k = 0; j + k < n; ) {
        let diff = s.charCodeAt(i + k) - s.charCodeAt(j + k);
        if (diff === 0) {
            k++;
        } else if (diff < 0) {
            i += k + 1;
            k = 0;
            if (i >= j) {
                j = i + 1;
            }
        } else {
            j += k + 1;
            k = 0;
        }
    }
    return s.substring(i);
};
