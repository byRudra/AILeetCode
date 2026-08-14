# 930. Binary Subarrays With Sum

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-subarrays-with-sum/)

`Array` · `Hash Table` · `Sliding Window` · `Prefix Sum`

## Intuition
Counting subarrays whose sum equals a target can be reduced to a difference of two “at most” counts.  
If we know how many subarrays have a sum ≤ goal and how many have a sum ≤ goal − 1, their difference is exactly the number of subarrays whose sum equals goal. This avoids enumerating every possible subarray.

## Approach
The helper `atMost(nums, goal)` uses a sliding‑window technique.  
* Maintain two pointers, `start` and `end`, and a running sum of the window `[start, end]`.  
* Expand `end` one step at a time, adding `nums[end]` to the sum.  
* While the sum exceeds `goal`, shrink the window from the left: subtract `nums[start]` and increment `start`.  
* After the window is valid, every subarray that ends at `end` and starts anywhere between `start` and `end` inclusive satisfies the ≤ goal condition.  
  The count of such subarrays is `end - start + 1`; add this to the running total.  
* Return the total count.

The main routine calls `atMost(nums, goal)` and `atMost(nums, goal-1)` (returning 0 when the goal is negative) and returns their absolute difference, which is the desired answer.

## Complexity
- **Time:** O(n) – each array element is added to and removed from the window at most once.  
- **Space:** O(1) – only a handful of integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Math.abs(atMost(nums, goal) - atMost(nums, goal - 1));
    }
    private static int atMost(int nums[], int goal){
        if (goal < 0) return 0;
        int count = 0;
        int start = 0;
        int currSum = 0;
        for(int end = 0; end < nums.length; end++){
            currSum += nums[end];
            while(currSum > goal){
                currSum -= nums[start++];
            }
            count += end - start + 1;
        }
        return count;
    }
}
```

---

**Runtime** 2 ms · **Memory** 50.8 MB

<sub>Synced by AILeetHub on 2026-08-14.</sub>
