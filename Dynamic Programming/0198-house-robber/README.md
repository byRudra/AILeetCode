# 198. House Robber

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/house-robber/)

`Array` · `Dynamic Programming`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int []dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
```

---

**Runtime** 0 ms · **Memory** 43 MB

<sub>Synced by AILeetHub on 2026-07-02.</sub>
