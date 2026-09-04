# 3904. Smallest Stable Index II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

`Array` · `Prefix Sum`

## Intuition  
The instability score at index i is the difference between the largest value seen so far (the prefix maximum) and the smallest value that can still appear (the suffix minimum). If we know the suffix minimum for every position, we can evaluate the score in a single forward scan while maintaining the running prefix maximum. A naïve solution would recompute the minimum of the suffix for each i, costing O(n²). Pre‑computing the suffix minima removes that repeated work and yields a linear‑time answer. This is a classic **prefix‑suffix** pattern.

## Approach  
1. **Build suffix minima** – Create an array `suffixMin` of length n.  
   *Initialize*: `suffixMin[n‑1] = nums[n‑1]`.  
   *Loop*: for `i = n‑2 … 0` set `suffixMin[i] = min(nums[i], suffixMin[i+1])`.  
   *Invariant*: after processing index i, `suffixMin[i]` equals the minimum of `nums[i…n‑1]`.  
   *Edge*: works for n = 1 because the loop body is skipped and the single element is stored.  

2. **Scan forward keeping the prefix maximum** – Initialise `max = Integer.MIN_VALUE`.  
   *Loop*: for `i = 0 … n‑1` do `max = max(max, nums[i])`.  
   *Check*: if `max - suffixMin[i] <= k` return `i`.  
   *Invariant*: before the check, `max` is the maximum of `nums[0…i]`.  

3. **No stable index** – If the forward loop finishes without returning, output `-1`.  

**Why the checks are correct**  
- The suffix array guarantees `suffixMin[i]` is the exact minimum of the right part, so no off‑by‑one errors arise.  
- The condition uses `<= k` as required by the definition of a stable index.  
- Using `Integer.MIN_VALUE` ensures the first iteration correctly sets `max` to `nums[0]`.  

## Dry Run  

Input: `nums = [5, 0, 1, 4]`, `k = 3`

| i | max (prefix) | suffixMin[i] | max - suffixMin[i] | note |
|---|--------------|--------------|--------------------|------|
| 0 | 5            | 0            | 5                  | max updated, condition false |
| 1 | 5            | 0            | 5                  | max unchanged, condition false |
| 2 | 5            | 1            | 4                  | condition still > k |
| 3 | 5            | 4            | 1                  | 1 ≤ 3 → return **3** |

After the fourth iteration `i = 3`, the instability score satisfies the bound, so the algorithm returns index 3, which matches the expected answer.

## Complexity  
- **Time:** O(n) – the backward pass fills `suffixMin` in n‑1 steps, and the forward pass examines each element once; the total work is linear.  
- **Space:** O(n) – the extra `suffixMin` array stores one integer per input element (output array or recursion stack not used).

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

**Runtime** 3 ms (beats 100.0%) · **Memory** 133.6 MB (beats 5.3%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
