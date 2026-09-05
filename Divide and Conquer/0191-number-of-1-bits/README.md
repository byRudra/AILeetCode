# 191. Number of 1 Bits

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-1-bits/)

`Divide and Conquer` · `Bit Manipulation`

## Intuition  
The binary representation of any 32‑bit integer can be examined one bit at a time by repeatedly looking at the least‑significant bit (LSB) and discarding it. After each right‑shift the original LSB becomes the new LSB, so a single loop of 32 iterations visits every position exactly once. The naïve alternative—converting the number to a string or repeatedly dividing by two—adds extra work proportional to the number of digits or incurs costly string handling. By exploiting the fact that a right‑shift is O(1) and that a bitwise AND with 1 isolates the LSB, we can count set bits in constant time using the **bit‑manipulation** pattern.

## Approach  
1. **Initialize** `count = 0`. This will accumulate the number of observed 1‑bits.  
2. **Loop** `for (int i = 0; i < 32; i++)`  
   - *Exit condition*: the loop stops after exactly 32 iterations, guaranteeing that every bit of a 32‑bit integer is examined.  
   - *Invariant*: at the start of each iteration `i`, the variable `n` holds the original input right‑shifted `i` times, and `count` equals the number of 1‑bits seen in the already‑processed `i` lower positions.  
   - **Check LSB**: `if ((n & 1) == 1) count++;`  
     - The expression `n & 1` extracts the current LSB; if it equals 1 we increment `count`.  
   - **Discard LSB**: `n = n >> 1;`  
     - An arithmetic right‑shift moves all bits one place toward the LSB, filling the high‑order bit with the sign bit. Because the input is guaranteed non‑negative (`1 ≤ n ≤ 2^31‑1`), the sign bit is 0, so the shift behaves like a logical shift.  
3. **Return** `count`. After the 32nd iteration every bit has been examined, and `count` holds the total number of set bits.

*Edge handling*: The loop runs even when `n` becomes zero early; the remaining iterations simply see `n & 1 == 0` and leave `count` unchanged, which is intentional and avoids special‑casing empty or single‑bit inputs. The bound `i < 32` (rather than `i <= 31`) matches the exact width of a signed 32‑bit integer in Java.

## Dry Run  
Input: `n = 11` (binary `0000 0000 0000 0000 0000 0000 0000 1011`)

| i | n (binary)                | LSB (`n & 1`) | count | note                         |
|---|---------------------------|---------------|-------|------------------------------|
| 0 | 000…1011                  | 1             | 1     | LSB is 1 → increment          |
| 1 | 000…0101 (after >>)       | 1             | 2     | LSB is 1 → increment          |
| 2 | 000…0010                  | 0             | 2     | LSB is 0 → no change          |
| 3 | 000…0001                  | 1             | 3     | LSB is 1 → increment          |
| 4 | 000…0000                  | 0             | 3     | n becomes 0, further loops do nothing |
| … | …                         | 0             | 3     | remaining iterations unchanged |
|31 | 000…0000                  | 0             | 3     | loop ends                     |

After the loop finishes, `count = 3`, which matches the three set bits in `1011`.

## Complexity  
- **Time:** O(1) – the loop executes a fixed 32 iterations regardless of the input value; each iteration performs only constant‑time bitwise operations.  
- **Space:** O(1) – only a few integer variables (`count`, `i`, `n`) are used, independent of the size of the input. (The output integer itself is not counted as extra space.)

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

**Runtime** 1 ms (beats 29.8%) · **Memory** 42.6 MB (beats 28.0%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
