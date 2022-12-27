/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
    const nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    const romans = [
        "M",
        "CM",
        "D",
        "CD",
        "C",
        "XC",
        "L",
        "XL",
        "X",
        "IX",
        "V",
        "IV",
        "I",
    ];
    const res = [];
    for (let i = 0; i < nums.length; i++) {
        while (num >= nums[i]) {
            res.push(romans[i]);
            num -= nums[i];
        }
    }
    return res.join("");
};
