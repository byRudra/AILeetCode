# 123. Best Time to Buy and Sell Stock III

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

`Array` · `Dynamic Programming`

## Intuition
The problem can be seen as performing at most two independent buy‑sell cycles.  
For each day we want to know the best profit that can be achieved if we have
completed 0, 1, or 2 transactions up to that point.  
By iterating once over the prices and updating four state variables we can
maintain these best values without revisiting earlier days.

## Approach
We keep four variables:
- `firstBuy`: maximum profit after buying the first stock (negative cost).
- `firstSell`: maximum profit after selling the first stock.
- `secondBuy`: maximum profit after buying the second stock, taking into account
  the profit already earned from the first sale.
- `secondSell`: maximum profit after selling the second stock.

For each price `p` we update in order:
1. `firstBuy = max(firstBuy, -p)` – either keep the previous best or buy now.
2. `firstSell = max(firstSell, firstBuy + p)` – sell the first stock if it
   improves profit.
3. `secondBuy = max(secondBuy, firstSell - p)` – buy the second stock using
   the profit from the first sale.
4. `secondSell = max(secondSell, secondBuy + p)` – sell the second stock if it
   yields a better total profit.

After processing all days, `secondSell` holds the maximum achievable profit
with at most two transactions.

## Complexity
- **Time:** O(n) – single pass over the price array.  
- **Space:** O(1) – only four integer variables are maintained regardless of input size.

## Solution (java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;


        for(int price : prices){
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
```

---

**Runtime** 1 ms · **Memory** 76.2 MB

<sub>Synced by AILeetHub on 2026-01-02.</sub>
