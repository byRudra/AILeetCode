# 122. Best Time to Buy and Sell Stock II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

`Array` · `Dynamic Programming` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Dynamic Programming, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
```

---

**Runtime** 0 ms · **Memory** 46.3 MB

<sub>Synced by AILeetHub on 2026-05-07.</sub>
