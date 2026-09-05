# 191. Number of 1 Bits

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-1-bits/)

`Divide and Conquer` · `Bit Manipulation`

## Intuition  
Each integer is stored as a fixed 32‑bit pattern, so the number of set bits can be obtained by examining the least‑significant bit (LSB) repeatedly. The key observation is that right‑shifting the number discards the already‑checked LSB and brings the next bit into position 0, allowing a constant‑time test `n & 1`. This eliminates the need for a conversion to a binary string, a hash‑based tally, or a variable‑length loop that stops when `n` becomes zero (which would fail for negative values in two’s‑complement). The pattern used is a simple **bit‑mask & shift** loop.

## Approach  
1. **Initialize** `count = 0`.  
2. **Iterate** `i` from `0` to `31` (inclusive) – the loop condition `i < 32` guarantees exactly 32 examinations, matching the width of a Java `int`.  
   - **Invariant:** after `i` iterations, the lowest `i` bits of the original number have been processed, `count` holds the number of `1`s among them, and `n` has been right‑shifted `i` times, so its current LSB corresponds to the original bit at position `i`.  
3. **Check LSB:** `if ((n & 1) == 1) count++;` – the bitwise AND isolates the current LSB; if it equals 1 we increment the tally.  
4. **Shift right:** `n = n >> 1;` – an arithmetic right shift moves every remaining bit one position toward the LSB, discarding the bit just examined. The loop uses `>>` (sign‑preserving) because we never rely on the sign after 32 iterations; the sign bit will be processed like any other bit.  
5. **Return** `count` after the loop finishes.  

**Edge‑case handling:**  
- The loop runs even when the input is `0`; all 32 iterations see `n & 1 == 0`, yielding a count of 0.  
- For the maximum positive `int` (`2^31‑1`) the sign bit is `0`, so the arithmetic shift does not introduce spurious `1`s.  
- The code deliberately chooses a fixed 32‑iteration bound (`i < 32`) rather than `while (n != 0)` to avoid an infinite loop on negative numbers where `>>` would keep the sign bit set.

## Dry Run  
Input: `n = 11` (binary `0000 0000 0000 0000 0000 0000 0000 1011`)

| i | n (binary)                     | LSB (`n & 1`) | count | note                         |
|---|--------------------------------|---------------|-------|------------------------------|
| 0 | 000…1011                       | 1             | 1     | LSB is 1 → increment          |
| 1 | 000…0101 (after `>>`)          | 1             | 2     | Next LSB is 1                |
| 2 | 000…0010                       | 0             | 2     | LSB 0 → count unchanged       |
| 3 | 000…0001                       | 1             | 3     | LSB 1 → increment            |
| 4 | 000…0000                       | 0             | 3     | All higher bits are 0 now    |
| 5 | 000…0000                       | 0             | 3     | Remaining iterations see 0   |
| … | …                              | …             | 3     | (iterations 5‑31 keep count) |
|31 | 000…0000                       | 0             | 3     | Loop ends                     |

After 32 iterations `count` equals 3, which is exactly the number of set bits in the original value 11.

## Complexity  
- **Time:** O(1) – the loop executes a constant 32 iterations regardless of the input magnitude (`fast` advances two bits per iteration in the sense of processing one bit and discarding it).  
- **Space:** O(1) – only a few primitive variables (`count`, `i`, `n`) are used; no additional data structures are allocated.

## Solution (Java)

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i < 32; i++) {

            if((n & 1) == 1) {
                count++;
            }

            n = n >> 1;
        }

        return count;
    }
}
```

---

**Runtime** 1 ms (beats 29.8%) · **Memory** 42.6 MB (beats 11.8%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
