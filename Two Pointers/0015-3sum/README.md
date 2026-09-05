# 15. 3Sum

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/3sum/)

`Array` · `Two Pointers` · `Sorting`

## Intuition  
If the array is sorted, any three numbers that sum to zero can be found by fixing the smallest of the three and then searching for a complementary pair whose sum is the negation of that fixed value. Because the list is ordered, moving a left pointer rightward always increases the pair sum, while moving a right pointer leftward always decreases it. This monotonic behavior lets us locate the needed pair in a single linear scan, eliminating the need for a second pass, a hash table, or nested loops that would yield O(n²) work per fixed element. The overall technique is the classic **two‑pointer** method applied after sorting.

## Approach  
1. **Sort the input** `nums`.  
2. **Iterate `i`** from `0` to `nums.length‑3`.  
   - *Exit condition*: `i < nums.length‑2`.  
   - *Invariant*: All indices `< i` have already been processed, and any triplet that starts with a smaller value has been recorded.  
   - *Duplicate guard*: If `i > 0 && nums[i] == nums[i‑1]`, `continue` to skip the same starting value.  
3. **Initialize two pointers**: `left = i + 1`, `right = nums.length‑1`.  
4. **While `left < right`**:  
   - Compute `sum = nums[i] + nums[left] + nums[right]`.  
   - *If `sum == 0`*: add the triplet, then `left++` and `right--`.  
     - Skip over equal neighbours: `while (left < right && nums[left] == nums[left‑1]) left++;` and similarly for `right`.  
   - *If `sum < 0`*: the current pair is too small, so `left++`.  
   - *If `sum > 0`*: the pair is too large, so `right--`.  
   - The loop invariant is that all pairs between the current `left` and `right` have not been examined yet, and the sorted order guarantees that moving pointers preserves the possibility of reaching sum = 0.  
5. After the inner loop finishes, proceed to the next `i`.  
6. Return `result`, the list of unique triplets.

## Dry Run  
Input: `[-1,0,1,2,-1,-4]` → after sorting → `[-4,-1,-1,0,1,2]`

| i | left | right | sum = nums[i]+nums[left]+nums[right] | note |
|---|------|-------|--------------------------------------|------|
|0 (-4) |1 (-1) |5 (2) | -3 | sum < 0 → left++ |
|0 (-4) |2 (-1) |5 (2) | -3 | sum < 0 → left++ |
|0 (-4) |3 (0)  |5 (2) | -2 | sum < 0 → left++ |
|0 (-4) |4 (1)  |5 (2) | -1 | sum < 0 → left++ (loop ends) |
|1 (-1) |2 (-1) |5 (2) | 0 | record `[-1,-1,2]`; left→3, right→4; skip duplicates none |
|1 (-1) |3 (0)  |4 (1) | 0 | record `[-1,0,1]`; left→4, right→3 (loop ends) |
|2 (-1) |3 (0)  |5 (2) | 1 | sum > 0 → right-- |
|2 (-1) |3 (0)  |4 (1) | 0 | duplicate start `i` (i>0 && nums[i]==nums[i‑1]) → skip whole iteration |

Final `result` = `[[-1,-1,2],[-1,0,1]]`, which are exactly the zero‑sum triplets.

## Complexity  
- **Time:** `O(n log n)` for the initial sort plus `O(n²)` for the double‑pointer scan; the inner while runs at most `n‑i‑1` steps, so the total is dominated by the quadratic phase.  
- **Space:** `O(1)` auxiliary space (ignoring the output list), because the algorithm only uses a few integer indices regardless of input size.

## Solution (Java)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);

       for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for 'i'
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicate values for 'left' and 'right'
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }
}
```

---

**Runtime** 34 ms (beats 58.8%) · **Memory** 59.2 MB (beats 45.2%)

<sub>Synced by AILeetHub on 2025-11-04.</sub>
