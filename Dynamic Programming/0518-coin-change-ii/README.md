# 518. Coin Change II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/coin-change-ii/)

`Array` · `Dynamic Programming` · `Knapsack Problem` · `Complete Knapsack`

## Intuition  
The problem is a classic complete‑knapsack variant: each coin can be used unlimited times, and we need the number of distinct multisets that sum to the target amount. A dynamic programming table that records “how many ways to reach a certain amount using a subset of the coins” naturally captures the combinatorial structure.

## Approach  
Let `dp[i][j]` denote the number of ways to make amount `j` using the first `i` coin types (`coins[0..i-1]`).  
* **Initialization** – For any `i`, there is exactly one way to make amount `0`: use no coins, so `dp[i][0] = 1`.  
* **Transition** – When considering the `i`‑th coin (value `coins[i-1]`):  
  * If the coin’s value exceeds `j`, it cannot be used, so `dp[i][j] = dp[i-1][j]`.  
  * Otherwise, we may either ignore this coin (`dp[i-1][j]`) or use it at least once. Using it once leaves a subproblem of size `j - coins[i-1]` that still allows the same coin, giving `dp[i][j - coins[i-1]]`.  
  Thus `dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]`.  
The answer is `dp[n][amount]`, where `n` is the number of coin types.

## Complexity  
- **Time:** O(n × amount) – each of the `n` rows iterates over all `amount` columns once.  
- **Space:** O(n × amount) – the 2‑D table stores a value for every pair `(i, j)` to preserve the complete‑knapsack state.

## Solution (java)

```java
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <=n ; i++){
            for(int j = 1; j <=amount; j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
```

---

**Runtime** 13 ms · **Memory** 56.8 MB

<sub>Synced by AILeetHub on 2026-04-09.</sub>
