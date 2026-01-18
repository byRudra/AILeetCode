# 1922. Count Good Numbers

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-good-numbers/)

`Math` · `Recursion`

## Intuition
A good string is determined independently at each position.  
- Even‑indexed positions (0,2,4,…) must contain an even digit: 0, 2, 4, 6, 8 → 5 choices.  
- Odd‑indexed positions (1,3,5,…) must contain a prime digit: 2, 3, 5, 7 → 4 choices.  

For a string of length `n`, the number of even indices is `ceil(n/2)` and the number of odd indices is `floor(n/2)`.  
Thus the total count is `5^(ceil(n/2)) * 4^(floor(n/2))` modulo `10^9+7`.  
The challenge is computing these large powers efficiently for `n` up to `10^15`.

## Approach
1. Compute `even = (n + 1) / 2` and `odd = n / 2`.  
2. Use fast exponentiation (binary exponentiation) to evaluate `5^even` and `4^odd` modulo `MOD`.  
   The recursive `power` function squares the result of `power(base, exp/2)` and, if `exp` is odd, multiplies once more by `base`.  
3. Multiply the two results modulo `MOD` to obtain the final answer.

The algorithm relies on the independence of digit choices at each position and the mathematical property that the total number of strings is the product of choices per position.

## Complexity
- **Time:** O(log n) – each exponentiation halves the exponent, requiring at most `log₂(n)` multiplications.  
- **Space:** O(log n) – recursion depth equals the number of bits in the exponent; otherwise constant auxiliary space.

## Solution (java)

```java
class Solution {
        static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long pow5 = power(5, even);
        long pow4 = power(4, odd);

        return (int) ((pow5 * pow4) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0)
            return 1;

        long half = power(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2026-01-18.</sub>
