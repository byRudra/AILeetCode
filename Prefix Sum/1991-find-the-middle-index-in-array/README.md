# 1991. Find the Middle Index in Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-middle-index-in-array/)

`Array` · `Prefix Sum`

## Intuition  
The condition for a middle index is that the sum of all elements to its left equals the sum of all elements to its right.  
If we know the total sum of the array, we can deduce the right‑hand sum at any position by subtracting the left sum and the current element from the total.  
Thus, a single pass that keeps track of the left sum suffices.

## Approach  
1. Compute `totalSum` by iterating once over the array.  
2. Iterate again, maintaining `leftSum`.  
   * For each index `i`, calculate `rightSum = totalSum - leftSum - nums[i]`.  
   * If `leftSum == rightSum`, return `i` immediately – this is the leftmost valid index.  
   * Add `nums[i]` to `leftSum` before moving to the next element.  
3. If the loop completes without a match, return `-1`.

This method guarantees the smallest qualifying index because we scan from left to right and stop at the first match.

## Complexity  
- **Time:** O(n) – two linear scans over the array.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for(int num : nums) totalSum += num;

        for(int i = 0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.4 MB

<sub>Synced by AILeetHub on 2026-05-07.</sub>
