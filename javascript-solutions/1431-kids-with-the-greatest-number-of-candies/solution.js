/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function (candies, extraCandies) {
    let maxCandies = 0;
    candies.forEach((candy) => {
        maxCandies = Math.max(candy, maxCandies);
    });
    let res = [];
    candies.forEach((candy) => {
        res.push(candy + extraCandies >= maxCandies);
    });
    return res;
};
