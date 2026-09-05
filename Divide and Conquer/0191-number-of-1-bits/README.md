# 191. Number of 1 Bits

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-1-bits/)

`Divide and Conquer` · `Bit Manipulation`

## Intuition  
The key observation is that a 32‑bit integer can be reduced to its Hamming weight with a single library call that internally applies a hardware‑accelerated popcount or a constant‑time divide‑and‑conquer algorithm. A naïve solution would scan each of the 32 bits, incrementing a counter, which costs O(32) ≈ O(1) time but still performs an explicit loop for every call. By delegating to `Integer.bitCount`, we eliminate the explicit per‑bit traversal and rely on the JVM’s highly tuned implementation. This follows the **bit‑manipulation primitive** pattern where a language‑provided intrinsic replaces manual bit fiddling.

## Approach  
1. **Invoke the intrinsic** – `int count = Integer.bitCount(n);`  
   *Exit condition*: The method returns immediately after computing the popcount; there is no loop in our code.  
   *Invariant*: None needed in our wrapper; the invariant is maintained inside the JDK implementation (e.g., after each internal step the partial sum equals the number of set bits processed so far).  
2. **Return the result** – `return count;`  
   No further checks are required because `bitCount` is defined for all `int` values, including the full‑range positive inputs specified by the problem.

*Edge‑case handling*: The wrapper does not need special cases for `0`, `1`, or the maximum signed int (`2^31‑1`). `Integer.bitCount` correctly returns `0` for `0` and `31` for `2^31‑1`. The method also works for negative values (interpreted as two’s‑complement), but the problem guarantees a positive `n`, so no extra guard is needed.

## Dry Run  
**Input**: `n = 11` (binary `1011`)

| Step | `n` (binary) | `count` after call | Note |
|------|--------------|--------------------|------|
| 1    | `1011`       | `3`                | `Integer.bitCount` counts three `1`s |
| 2    | –            | –                  | `return count` yields `3` |

The method finishes after a single call to the intrinsic, and the returned value `3` matches the number of set bits in `1011`.

## Complexity  
- **Time:** O(1) – `Integer.bitCount` executes a constant‑time popcount instruction or a fixed sequence of arithmetic operations independent of the actual number of set bits.  
- **Space:** O(1) – only a few primitive variables (`count`) are allocated; no additional data structures are created.

## Solution (Java)

```java
class Solution {
    public int hammingWeight(int n) {
        int count = Integer.bitCount(n);
        return count;
    }
}
```

---

**Runtime** 1 ms (beats 29.8%) · **Memory** 42.3 MB (beats 65.5%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
