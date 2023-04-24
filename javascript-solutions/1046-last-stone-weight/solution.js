/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function (stones) {
    const maxheap = new MaxPriorityQueue();
    for (const stone of stones) {
        maxheap.enqueue("x", stone);
    }
    while (maxheap.size() > 1) {
        const b = maxheap.dequeue()["priority"];
        const a = maxheap.dequeue()["priority"];
        if (a != b) {
            maxheap.enqueue("x", b - a);
        }
    }
    return maxheap.isEmpty() ? 0 : maxheap.dequeue()["priority"];
};
