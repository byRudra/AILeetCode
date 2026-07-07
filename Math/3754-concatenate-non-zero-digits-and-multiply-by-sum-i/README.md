# 3754. Concatenate Non-Zero Digits and Multiply by Sum I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/)

`Math`

## Approach

Accepted easy solution in java.
Relevant topics: Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long place = 1;
        long sum = 0;
        while(n != 0){
            long digit = n % 10;
            if(digit != 0){
                x += digit * place;
                place *= 10;
                sum += digit;
            }
            n /= 10;
        }
        return x * sum;
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.6 MB

<sub>Synced by AILeetHub on 2026-07-07.</sub>
