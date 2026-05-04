# 53. Maximum Subarray

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-subarray/)

`Array` · `Divide and Conquer` · `Dynamic Programming`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Divide and Conquer, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentArray = nums[0];
        int maxArray = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentArray = Math.max(nums[i], currentArray + nums[i]);
            maxArray = Math.max(currentArray, maxArray);
        }
        return maxArray;
    }
}
```

---

**Runtime** 1 ms · **Memory** 77.3 MB

<sub>Synced by AILeetHub on 2026-05-04.</sub>
