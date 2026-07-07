# 213. House Robber II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/house-robber-ii/)

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
    public int helpRob(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(helpRob(nums, 1, n - 1), helpRob(nums, 0, n - 2));
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.8 MB

<sub>Synced by AILeetHub on 2026-07-07.</sub>
