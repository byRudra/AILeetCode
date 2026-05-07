# 121. Best Time to Buy and Sell Stock

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

`Array` · `Dynamic Programming`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];

        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
```

---

**Runtime** 1 ms · **Memory** 94.4 MB

<sub>Synced by AILeetHub on 2026-05-07.</sub>
