# 3689. Maximum Total Subarray Value I

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-i/)

`Array` · `Greedy`

## Intuition
The value of a subarray is the difference between its maximum and minimum elements.  
If we choose the subarray that spans the entire array, its value is `max(nums) – min(nums)`.  
Because subarrays may overlap and we are allowed to pick the same subarray multiple times, repeating the full‑array subarray `k` times yields a total value of  
`k * (max(nums) – min(nums))`.  
No other choice can produce a larger difference for any single subarray, so this is the optimal strategy.

## Approach
1. Scan the input array once to find the global minimum and maximum values.  
2. Compute the difference `max - min`.  
3. Multiply this difference by `k` and return the result as a `long` to avoid overflow.

The algorithm relies on the fact that the best subarray is always the one covering the whole array, and repeating it maximizes the total value.

## Complexity
- **Time:** O(n) – a single pass over the array to find min and max.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minSubArray = Integer.MAX_VALUE;
        int maxSubArray = Integer.MIN_VALUE;
        for(int num : nums){
            minSubArray = Math.min(minSubArray, num);
            maxSubArray = Math.max(maxSubArray, num);
        }
        return 1L * k * (maxSubArray - minSubArray);
    }
}
```

---

**Runtime** 1 ms · **Memory** 62.2 MB

<sub>Synced by AILeetHub on 2026-06-09.</sub>
