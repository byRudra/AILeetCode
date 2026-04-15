# 1848. Minimum Distance to the Target Element

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-distance-to-the-target-element/)

`Array`

## Approach

Accepted easy solution in java.
Relevant topics: Array.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] == target){
                minDistance = Math.min(minDistance, Math.abs(i-start));
            }
        }
        return minDistance;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.9 MB

<sub>Synced by AILeetHub on 2026-04-15.</sub>
