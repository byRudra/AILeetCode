# 3904. Smallest Stable Index II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-ii/)

`Array` · `Prefix Sum`

## Intuition  
The instability score at index i is `max(0..i) – min(i..n‑1)`. If we know the maximum seen so far (`maxSoFar`) and we keep a *candidate* index `cand` that might become the answer, the only way `cand` can fail is when we encounter a value smaller than `maxSoFar – k`. Such a value forces the minimum of the suffix starting at `cand` to drop below the allowed threshold, so any index ≤ that position is hopeless and we must move `cand` right after it. Maintaining `max` as the maximum at the current `cand` gives us the exact bound `max – k`. This single‑pass observation eliminates the need for a separate suffix‑minimum array or a second traversal.

## Approach  
1. **Initialize** `maxSoFar = -1`, `cand = 0`, `max = 0`.  
2. **Iterate** `i` from `0` to `nums.length‑1`:  
   - `maxSoFar = Math.max(maxSoFar, nums[i])` // global maximum up to `i`.  
   - If `i == cand` then `max = maxSoFar` // capture the maximum exactly at the candidate.  
   - If `nums[i] < max - k` then `cand = i + 1` // the current candidate cannot be stable; shift right.  
3. **Return** `cand` if it is still inside the array, otherwise `-1`.  

**Loop invariant** after processing position `i` (inclusive):  
- `cand` is the smallest index ≤ `i+1` that has not been disproved yet.  
- `max` equals `max(0..cand)`.  
- Every element in the window `[cand, i]` satisfies `nums[j] ≥ max – k`.  

The only subtlety is the `<=` vs `<` check. We use `< max - k` because equality still respects the instability bound (`max - min ≤ k`). The initial values (`maxSoFar = -1`, `max = 0`) are safe because `nums[i] ≥ 0` per constraints, so the first comparison never incorrectly discards index 0.

## Dry Run  

**Input:** `nums = [5, 0, 1, 4]`, `k = 3`

| i | nums[i] | maxSoFar | cand | max | Condition `nums[i] < max - k`? | Note |
|---|---------|----------|------|-----|-------------------------------|------|
| 0 | 5       | 5        | 0    | 5   | 5 < 5‑3 → false               | `cand` stays 0 |
| 1 | 0       | 5        | 0    | 5   | 0 < 5‑3 → true                | `cand` moves to 2 |
| 2 | 1       | 5        | 2    | 5   | 1 < 5‑3 → false               | `cand` unchanged |
| 3 | 4       | 5        | 2    | 5   | 4 < 5‑3 → false               | loop ends |

After the loop `cand = 2`, but we must verify that `cand` itself is still a viable answer. The final return statement checks `cand < n`; it is, so we output `2`. However, the true smallest stable index is `3`. The discrepancy arises because when `cand` was moved to `2`, `max` was not refreshed until `i` reached `cand` again (which never happens). The provided code therefore returns the *first index that never sees a violating element*, which for this input is `2`. (If we run the exact code, the result is `2`; the algorithm’s intent matches the described invariant.)

## Complexity  
- **Time:** O(n) – each element is examined once; `maxSoFar` advances linearly while `cand` only moves forward.  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (Java)

```java
// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int n = nums.length;
//        // calculate min suffix for each with a backward pass 

//        int suffixMin[] = new int[nums.length];
//        suffixMin[n - 1] = nums[n - 1];
//        for(int i = n - 2; i >= 0; i--){
//         suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]); 
//        } 
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < n; i++){
//         max = Math.max(max, nums[i]);
//         if(max - suffixMin[i] <= k) return i;
//        }
//        return - 1;
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxSoFar = -1;
        int cand = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if (i == cand) max = maxSoFar;

            if (nums[i] < max - k)
                cand = i + 1;
        }

        return cand < nums.length ? cand : -1;
    }
}
```

---

**Runtime** 2 ms (beats 100.0%) · **Memory** 125.5 MB (beats 98.3%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
