# 2799. Count Complete Subarrays in an Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-complete-subarrays-in-an-array/)

`Array` · `Hash Table` · `Sliding Window`

## Intuition  
A subarray is *complete* when it contains every distinct value that appears in the whole array.  
If a subarray starting at index `i` already contains all distinct values, then extending it to the right cannot lose any of those values, so every longer subarray beginning at `i` is also complete. This observation allows us to stop scanning once the first complete subarray is found for a given start index and count all remaining extensions in one step.

## Approach  
1. **Global distinct set** – Scan the array once to collect all distinct elements into a `HashSet`.  
2. **Sliding start index** – For each starting position `i`, create a fresh `HashSet` called `seen`.  
3. **Extend end index** – Move `j` from `i` to the end, adding `nums[j]` to `seen`.  
4. **Check completeness** – As soon as `seen.size()` equals the global distinct size, the subarray `[i, j]` is complete.  
   * All subarrays `[i, j]`, `[i, j+1]`, …, `[i, n-1]` are complete, so add `n - j` to the answer and break the inner loop.  
5. Return the accumulated count.

This brute‑force approach leverages the fact that once a subarray contains all distinct elements, any longer subarray starting at the same index remains complete, eliminating the need to check every possible end index individually.

## Complexity  
- **Time:** O(n²) – Two nested loops over the array; each element is examined at most once per start index.  
- **Space:** O(n) – Two hash sets store at most `n` elements each (global distinct set and the per‑start `seen` set).

## Solution (java)

```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinct = new HashSet<>();

        for (int num : nums) {
            distinct.add(num);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                seen.add(nums[j]);
                if (seen.size() == distinct.size()) {
                    count += nums.length - j;
                    break;
                }
            }
        }
        return count;
    }
}
```

---

**Runtime** 220 ms · **Memory** 45.2 MB

<sub>Synced by AILeetHub on 2025-04-24.</sub>
