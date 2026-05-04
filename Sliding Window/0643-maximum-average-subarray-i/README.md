# 643. Maximum Average Subarray I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-average-subarray-i/)

`Array` · `Sliding Window`

## Intuition  
The average of a subarray of length k is maximized when its sum is maximized.  
Instead of recomputing the sum for every possible window, we can maintain a running sum that changes only by the element that enters and the element that leaves the window.

## Approach  
1. Compute the sum of the first `k` elements.  
2. Store this as the current maximum sum.  
3. Slide the window one position at a time:  
   * Add the new element entering the window.  
   * Subtract the element that is leaving the window.  
   * Update the maximum sum if the new window sum is larger.  
4. After processing all windows, divide the maximum sum by `k` to obtain the maximum average.

The algorithm uses a single pass over the array and updates the sum in constant time per step.

## Complexity  
- **Time:** O(n) – one traversal of the array, each step performs O(1) work.  
- **Space:** O(1) – only a few numeric variables are kept regardless of input size.

## Solution (java)

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }
        return max / k;
    }
}
```

---

**Runtime** 4 ms · **Memory** 69.8 MB

<sub>Synced by AILeetHub on 2026-05-04.</sub>
