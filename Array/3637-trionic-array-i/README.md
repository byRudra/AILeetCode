# 3637. Trionic Array I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/trionic-array-i/)

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
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4)
            return false;
        int i = 0;

        // Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        if(i == 0 || i == n - 1) return false;
        
        // Decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        if(i == 0 || i == n - 1) return false;
        
        // Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        
        return i == n-1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.8 MB

<sub>Synced by AILeetHub on 2026-02-22.</sub>
