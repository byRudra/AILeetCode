# 3904. Smallest Stable Index II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

`Array` · `Prefix Sum`

## Intuition  
The instability score at index i depends only on two values: the largest element seen so far from the left (prefix maximum) and the smallest element that can appear from i to the end (suffix minimum). If we know these two arrays, we can evaluate the score for every i in a single pass and stop at the first index that satisfies the bound k.

## Approach  
1. **Suffix minima** – Scan the array from right to left, building `suffixMin[i]` as the minimum of `nums[i]` and `suffixMin[i+1]`. After this pass, `suffixMin[i]` equals `min(nums[i..n‑1])`.  
2. **Forward scan** – Initialise `maxSoFar` to negative infinity. Iterate i from 0 to n‑1, updating `maxSoFar = max(maxSoFar, nums[i])`. The instability score at i is `maxSoFar - suffixMin[i]`. If this value ≤ k, return i immediately.  
3. If the loop finishes without a match, return –1.

The algorithm directly follows the definition of the score and guarantees the smallest qualifying index because we examine indices in increasing order.

## Complexity  
- **Time:** O(n) – one backward pass to fill `suffixMin` and one forward pass to test each index.  
- **Space:** O(n) – the extra array `suffixMin` stores a value for each position.

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

**Runtime** 4 ms (beats 88.5%) · **Memory** 133.5 MB (beats 8.0%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
