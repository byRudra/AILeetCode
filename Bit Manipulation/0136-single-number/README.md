# 136. Single Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/single-number/)

`Array` · `Bit Manipulation`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Bit Manipulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int singleNumber(int[] nums) {
        int bit = nums[0];
        for(int i = 1; i < nums.length; i++){
            bit ^= nums[i];
        }
        return bit;
    }
}
```

---

**Runtime** 1 ms · **Memory** 47 MB

<sub>Synced by AILeetHub on 2026-08-14.</sub>
