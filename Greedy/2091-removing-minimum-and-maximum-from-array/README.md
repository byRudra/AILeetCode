# 2091. Removing Minimum and Maximum From Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)

`Array` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int n = nums.length;

        int fromFront = Math.max(minIndex, maxIndex) + 1;
        int fromBack = n - Math.min(minIndex, maxIndex);
        int fromBoth = Math.min(minIndex, maxIndex) + 1 + n - Math.max(minIndex, maxIndex);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }
}
```

---

**Runtime** 2 ms · **Memory** 86.5 MB

<sub>Synced by AILeetHub on 2026-08-30.</sub>
