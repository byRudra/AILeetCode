# 7. Reverse Integer

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-integer/)

`Math`

## Intuition  
Reversing an integer can be done by repeatedly taking its last digit and appending it to a new number.  
The challenge is to avoid overflow when the reversed value exceeds the 32‑bit signed range.  
Because the environment forbids 64‑bit arithmetic, we must detect potential overflow *before* it occurs.

## Approach  
1. Initialize `reversed = 0`.  
2. While the input `x` is non‑zero:  
   * Extract the last digit: `digit = x % 10`.  
   * Remove that digit from `x`: `x /= 10`.  
   * **Overflow check** – before multiplying `reversed` by 10 and adding `digit`, verify that the operation will stay within bounds:  
     * For positive numbers: if `reversed > Integer.MAX_VALUE/10` or `reversed == Integer.MAX_VALUE/10 && digit > 7`, return 0.  
     * For negative numbers: if `reversed < Integer.MIN_VALUE/10` or `reversed == Integer.MIN_VALUE/10 && digit < -8`, return 0.  
   * Update `reversed = reversed * 10 + digit`.  
3. Return the accumulated `reversed`.

The checks use the fact that the last digit of `Integer.MAX_VALUE` is 7 and of `Integer.MIN_VALUE` is 8, ensuring that any multiplication by 10 followed by addition would stay within the 32‑bit signed range.

## Complexity  
- **Time:** O(log₁₀|x|) – each loop removes one decimal digit.  
- **Space:** O(1) – only a few integer variables are used, regardless of input size.

## Solution (java)

```java
class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check positive overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check negative overflow
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }
}
```

---

**Runtime** 1 ms · **Memory** 41.8 MB

<sub>Synced by AILeetHub on 2026-08-25.</sub>
