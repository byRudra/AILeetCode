# 3925. Concatenate Array With Reverse

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/concatenate-array-with-reverse/)

`Array` · `Simulation`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int length = nums.length;
        int resultArray[] = new int[length * 2];
        for(int i = 0; i < length; i++){
            resultArray[i] = nums[i];
            resultArray[length + length - 1 - i] = nums[i];
        }
        return resultArray;

    }
}
```

---

**Runtime** 1 ms · **Memory** 47.4 MB

<sub>Synced by AILeetHub on 2026-06-24.</sub>
