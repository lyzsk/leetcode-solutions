/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    let minPrice = Number.MAX_VALUE;
    let res = 0;
    prices.forEach((price) => {
        minPrice = Math.min(minPrice, price);
        res = Math.max(res, price - minPrice);
    });
    return res;
};
