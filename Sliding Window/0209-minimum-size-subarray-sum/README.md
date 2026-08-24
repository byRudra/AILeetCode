# 209. Minimum Size Subarray Sum

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-size-subarray-sum/)

`Array` · `Binary Search` · `Sliding Window` · `Prefix Sum`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Binary Search, Sliding Window, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int curr = 0;
        int min = Integer.MAX_VALUE;

        for(; end < nums.length; end++){
            curr += nums[end];
            while(curr >= target){
                min = Math.min(end - start + 1, min);
                curr -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
```

---

**Runtime** 1 ms · **Memory** 69.2 MB

<sub>Synced by AILeetHub on 2026-08-24.</sub>
