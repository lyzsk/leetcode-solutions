function arrayRankTransform(arr: number[]): number[] {
    const n = arr.length;
    const sortedArr = [...arr].sort((a, b) => a - b);
    const rankMap = new Map<number, number>();
    const res: number[] = new Array(n);
    for (const item of sortedArr) {
        if (!rankMap.has(item)) {
            rankMap.set(item, rankMap.size + 1);
        }
    }
    for (let i = 0; i < n; i++) {
        res[i] = rankMap.get(arr[i])!;
    }
    return res;
}
