/**
 * @param {number[]} nums
 * @return {number}
 */
var findRepeatNumber = function (nums) {
    let set = new Set();
    for (let num of nums) {
        if (set.has(num)) {
            return num;
        } else {
            set.add(num);
        }
    }
    return -1;
};
