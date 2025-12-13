# 1137. N-th Tribonacci Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/n-th-tribonacci-number/)

`Math` · `Dynamic Programming` · `Memoization`

## Intuition  
The Tribonacci sequence grows by adding the previous three terms.  
Because each new value depends only on the last three, we can compute the sequence iteratively while keeping just those three numbers in memory. This avoids the exponential blow‑up of a naive recursive definition.

## Approach  
1. Handle the base cases `n = 0, 1, 2` directly, returning `0, 1, 1`.  
2. Initialize three variables to represent the last three Tribonacci numbers:  
   `first = 0` (T₀), `second = 1` (T₁), `third = 1` (T₂).  
3. Starting from index 3, iterate until `i == n`.  
   * Compute the next value: `temp = first + second + third`.  
   * Shift the window: `first = second; second = third; third = temp;`.  
   * Increment `i`.  
4. After the loop, the sum of the three variables equals Tₙ, so return `first + second + third`.

This method uses a single pass over the indices, updating the window in constant time per iteration.

## Complexity  
- **Time:** O(n) – one simple loop that runs `n‑3` times.  
- **Space:** O(1) – only three integer variables are maintained regardless of `n`.

## Solution (java)

```java
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int first = 0, second = 1, third = 1;
        int i = 3;
        while(i < n){
            int temp = first + second + third;
            first = second;
            second = third;
            third = temp;
            i++;
        }
        return  first + second + third;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42 MB

<sub>Synced by AILeetHub on 2025-12-13.</sub>
