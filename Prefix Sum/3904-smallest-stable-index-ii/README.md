# 3904. Smallest Stable Index II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

`Array` · `Prefix Sum`

## Intuition  
For each index *i* we need the largest value up to *i* and the smallest value from *i* to the end.  
If we can answer the second part in constant time for every *i*, we can scan once from left to right, keeping the running maximum, and stop at the first index whose difference is ≤ *k*.

## Approach  
1. **Suffix minima** – Traverse the array from right to left, storing at each position the minimum value seen so far.  
   `suffixMin[i] = min(nums[i], suffixMin[i+1])`.  
   After this pass, `suffixMin[i]` equals `min(nums[i…n‑1])`.  
2. **Prefix maximum & check** – Scan the array from left to right, maintaining the maximum value seen so far (`max`).  
   For each index *i*, compute `max - suffixMin[i]`.  
   If this difference is ≤ *k*, return *i* immediately; otherwise continue.  
3. If no index satisfies the condition, return –1.

The algorithm uses the pre‑computed suffix minima to evaluate each instability score in O(1) time, guaranteeing the earliest stable index is found.

## Complexity  
- **Time:** O(n) – one backward pass to build suffix minima and one forward pass to find the answer.  
- **Space:** O(n) – an auxiliary array of length *n* stores the suffix minima.

## Solution (Java)

```java
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
       // calculate min suffix for each with a backward pass 

       int suffixMin[] = new int[nums.length];
       suffixMin[n - 1] = nums[n - 1];
       for(int i = n - 2; i >= 0; i--){
        suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]); 
       } 
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
        max = Math.max(max, nums[i]);
        if(max - suffixMin[i] <= k) return i;
       }
       return - 1;
    }
}
```

---

**Runtime** 4 ms (beats 88.5%) · **Memory** 133 MB (beats 36.3%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
