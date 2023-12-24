/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function (s) {
    let cntZeros = 0;
    let cntOnes = 0;
    for (let i = 0; i < s.length; i++) {
        let ch = s.charAt(i);
        if (i % 2 === 0) {
            if (ch === "0") {
                ++cntOnes;
            } else {
                ++cntZeros;
            }
        } else {
            if (ch === "1") {
                ++cntOnes;
            } else {
                ++cntZeros;
            }
        }
    }
    return Math.min(cntZeros, cntOnes);
};
