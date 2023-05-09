/**
 * @param {string} time
 * @return {number}
 */
var countTime = function (time) {
    let hrCnt = 0;
    let minCnt = 0;
    for (let i = 0; i < 24; i++) {
        const fstHr = Math.floor(i / 10);
        const secHr = i % 10;
        if (
            (time[0] === "?" || time[0] === fstHr + "") &&
            (time[1] === "?" || time[1] === secHr + "")
        ) {
            ++hrCnt;
        }
    }
    for (let i = 0; i < 60; i++) {
        const fstMin = Math.floor(i / 10);
        const secMin = i % 10;
        if (
            (time[3] === "?" || time[3] === fstMin + "") &&
            (time[4] === "?" || time[4] === secMin + "")
        ) {
            ++minCnt;
        }
    }
    return hrCnt * minCnt;
};
