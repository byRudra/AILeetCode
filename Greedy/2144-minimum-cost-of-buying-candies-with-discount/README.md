# 2144. Minimum Cost of Buying Candies With Discount

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/)

`Array` · `Greedy` · `Sorting`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Greedy, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int max = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            max += cost[i];
            if (i - 1 >= 0) {
                max += cost[i - 1];
            }
        }
        return max;
    }

}
```

---

**Runtime** 5 ms · **Memory** 44.9 MB

<sub>Synced by AILeetHub on 2026-06-01.</sub>
