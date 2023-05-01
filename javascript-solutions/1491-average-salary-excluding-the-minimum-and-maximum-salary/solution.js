/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function (salary) {
    const minv = Math.min(...salary);
    const maxv = Math.max(...salary);
    let sum = 0;
    const n = salary.length;
    for (let s of salary) {
        sum += s;
    }
    return (sum - minv - maxv) / (n - 2);
};
