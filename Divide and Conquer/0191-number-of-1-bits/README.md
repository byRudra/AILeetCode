# 191. Number of 1 Bits

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/number-of-1-bits/)

`Divide and Conquer` · `Bit Manipulation`

## Approach

Accepted easy solution in Java.
Relevant topics: Divide and Conquer, Bit Manipulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

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

**Runtime** 1 ms (beats 29.8%) · **Memory** 42.5 MB (beats 47.0%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
