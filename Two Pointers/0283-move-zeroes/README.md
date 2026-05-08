# 283. Move Zeroes

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/move-zeroes/)

`Array` · `Two Pointers`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int position = 0;
        for(int num : nums){
            if(num != 0) nums[position++] = num;
        }
        while(position < nums.length){
            nums[position++] = 0;
        }
    }
}
```

---

**Runtime** 1 ms · **Memory** 48.1 MB

<sub>Synced by AILeetHub on 2026-05-08.</sub>
