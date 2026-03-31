# 319. Bulb Switcher

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/bulb-switcher/)

`Math` · `Brainteaser`

## Intuition
A bulb ends up **on** only if it is toggled an odd number of times.  
Bulb *k* is toggled once for every divisor of *k* (rounds that are multiples of *k*).  
Thus the number of toggles equals the number of divisors of *k*.  
Only perfect squares have an odd divisor count because divisors normally come in pairs *(d, k/d)*; for a square one pair collapses into a single divisor.  
Hence, after all rounds, the bulbs that remain on are exactly those whose positions are perfect squares.

## Approach
The problem reduces to counting how many perfect squares are ≤ *n*.  
The largest integer *m* such that *m²* ≤ *n* is the integer part of √*n*.  
The provided solution simply returns `Math.sqrt(n)` cast to an `int`, which truncates the fractional part, yielding the desired count.

## Complexity
- **Time:** O(1) – a single square‑root computation.  
- **Space:** O(1) – only a few primitive variables are used.

## Solution (java)

```java
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);

    }
}
```

---

**Runtime** 0 ms · **Memory** 42 MB

<sub>Synced by AILeetHub on 2026-03-31.</sub>
