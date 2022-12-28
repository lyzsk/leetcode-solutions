/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @return {number[]}
 */
var twoOutOfThree = function (nums1, nums2, nums3) {
    let res = [];
    const hash = new Array(101).fill(0);
    for (const num of nums1) {
        if (hash[num] == 0) {
            ++hash[num];
        }
    }
    for (const num of nums2) {
        if (hash[num] == 0) {
            hash[num] += 2;
        } else if (hash[num] == 1) {
            hash[num] += 2;
            res.push(num);
        }
    }
    for (const num of nums3) {
        if (hash[num] == 1 || hash[num] == 2) {
            hash[num] += 3;
            res.push(num);
        }
    }
    return res;
};
