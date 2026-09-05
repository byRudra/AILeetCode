# 3904. Smallest Stable Index II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

`Array` · `Prefix Sum`

## Intuition  
The instability score at index i is completely determined by two independent pieces of information: the largest value seen so far from the left (prefix max) and the smallest value that will appear from i to the end (suffix min). If we can obtain the suffix minima for every position in a single backward pass, the forward scan only needs to keep a running maximum, turning the naïve O(n²) “re‑compute max/min for each i” into O(n). This observation eliminates the need for a hash map, sorting, or a second pass per index. The pattern used is a classic **prefix‑max / suffix‑min** pre‑computation.

## Approach  
1. **Build suffix minima**  
   *Initialize* `suffixMin[n‑1] = nums[n‑1]`.  
   *Loop* `i` from `n‑2` down to `0` (inclusive).  
   *Invariant*: after processing index i, `suffixMin[i]` holds `min(nums[i], suffixMin[i+1])`, i.e. the minimum of the sub‑array `[i … n‑1]`.  
   *Exit*: when `i == -1`. This pass runs exactly `n‑1` iterations.

2. **Scan forward with a running maximum**  
   *Initialize* `max = Integer.MIN_VALUE`.  
   *Loop* `i` from `0` to `n‑1`.  
   *Invariant*: before the check at iteration i, `max` equals `max(nums[0..i])`.  
   *Update*: `max = Math.max(max, nums[i])`.  
   *Check*: if `max - suffixMin[i] <= k` return `i` immediately.  
   *Edge handling*:  
   - Empty array never occurs because constraints guarantee `n ≥ 1`.  
   - Single‑element case works because `suffixMin[0] = nums[0]` and `max` becomes `nums[0]`, yielding score 0.  
   - The comparison uses `<=` (not `<`) because the definition of a stable index includes equality with k.  

3. **No stable index found**  
   After the forward loop finishes without returning, the method returns `-1`.

## Dry Run  
Input: `nums = [5, 0, 1, 4]`, `k = 3`

| i | max (prefix max) | suffixMin[i] | max - suffixMin[i] | Action |
|---|------------------|--------------|--------------------|--------|
| 0 | 5                | 0            | 5                  | 5 > 3 → continue |
| 1 | 5                | 0            | 5                  | 5 > 3 → continue |
| 2 | 5                | 1            | 4                  | 4 > 3 → continue |
| 3 | 5                | 4            | 1                  | 1 ≤ 3 → return **3** |

The suffix minima array built in step 1 is `[0,0,1,4]`. The forward scan updates `max` as shown, and at index 3 the instability score satisfies the bound, so the algorithm returns 3, which matches the expected answer.

## Complexity  
- **Time:** O(n) – the backward pass visits each element once to fill `suffixMin`, and the forward pass visits each element once while updating `max`.  
- **Space:** O(n) – the extra `suffixMin` array stores one integer per input element; the output index is returned directly, and no additional data structures are used.

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

**Runtime** 4 ms (beats 88.5%) · **Memory** 133.2 MB (beats 27.9%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
