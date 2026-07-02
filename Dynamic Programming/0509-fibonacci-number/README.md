# 509. Fibonacci Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/fibonacci-number/)

`Math` · `Dynamic Programming` · `Recursion` · `Memoization`

## Intuition  
The Fibonacci sequence is defined recursively, but naive recursion recomputes the same subproblems many times. By remembering only the two most recent values we can generate each next number in constant time, turning the exponential recursion into a linear loop. This bottom‑up dynamic programming method avoids repeated work.

## Approach  
We first handle the trivial cases `n = 0` and `n = 1`, returning `n` directly. For `n ≥ 2` we set `prev2 = 0` (F(0)) and `prev1 = 1` (F(1)). Then we iterate `i` from 2 up to `n` inclusive. In each iteration we compute `curr = prev1 + prev2`, which equals F(i). We then shift the window: `prev2` becomes the old `prev1`, and `prev1` becomes `curr`. After the loop, `prev1` holds F(n). Because each new value depends only on the previous two, the loop naturally propagates the sequence forward. The algorithm uses only two integer variables and a single for‑loop, avoiding recursion and extra memory.

## Complexity  
- **Time:** O(n) – a single loop that runs n‑1 times.  
- **Space:** O(1) – only two integer variables are maintained regardless of n.

## Solution (java)

```java
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2026-07-02.</sub>
