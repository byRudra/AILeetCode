# 70. Climbing Stairs

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/climbing-stairs/)

`Math` · `Dynamic Programming` · `Memoization`

## Intuition  
Each climb ends either on step n‑1 followed by one step or on step n‑2 followed by two steps.  
Thus the total ways to reach step n are the sum of the ways to reach those two preceding steps.  
This recurrence is identical to the Fibonacci sequence, with base cases 1 and 2 for the first two steps.

## Approach  
Create an integer array `dp` of length `n+1`.  
* If `n` is 1 or 2, return the corresponding base value.  
* Set `dp[1] = 1` and `dp[2] = 2`.  
* For each `i` from 3 to `n`, compute `dp[i] = dp[i-1] + dp[i-2]`.  
* Finally return `dp[n]`.  
The loop builds the table bottom‑up, ensuring each subproblem is solved once.

## Complexity  
- **Time:** O(n) – one pass over the range 3…n.  
- **Space:** O(n) – an array of size n+1 to store intermediate counts.

## Solution (java)

```java
class Solution {
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        if (n == 1){return 1;}
        if (n == 2){return 2;}
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

---

**Runtime** 0 ms · **Memory** 41 MB

<sub>Synced by AILeetHub on 2025-04-02.</sub>
