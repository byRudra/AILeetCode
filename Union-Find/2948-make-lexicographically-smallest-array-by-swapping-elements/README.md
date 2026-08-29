# 2948. Make Lexicographically Smallest Array by Swapping Elements

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)

`Array` · `Union-Find` · `Sorting`

## Intuition  
If two elements can be swapped, then any element that is reachable through a chain of such swaps can be permuted arbitrarily.  
Within each connected component of this “swap graph” the multiset of values is fixed, but we can reorder them freely.  
To obtain the lexicographically smallest array we should place the smallest values of a component at the smallest original indices of that component.

## Approach  
1. **Sort indices by value** – create an array `order` of indices and sort it using `nums[order[i]]`.  
2. **Identify swap‑connected components** – iterate through the sorted indices; a new component starts when the difference between consecutive values exceeds `limit`.  
3. **Reorder each component** – for the indices belonging to a component,  
   * extract the corresponding values (already sorted because `order` is sorted by value),  
   * sort the indices of the component by their original position (default `Integer` sort),  
   * assign the sorted values to the sorted indices, writing the result into `ans`.  
4. Return `ans`.

This guarantees that within every component the smallest values occupy the earliest positions, yielding the lexicographically minimal array.

## Complexity  
- **Time:** O(n log n) – sorting the indices once and sorting each component (total linearithmic).  
- **Space:** O(n) – auxiliary arrays `order`, `ans`, and temporary value arrays.

## Solution (java)

```java
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        //Defining and sorting the order in which the nums are; 

        Integer order[] = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;

        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int ans[] = new int[n];
        int i = 0;
        while (i < n) {
            int j = i + 1;

            while (j < n && nums[order[j]] - nums[order[j - 1]] <= limit)
                j++;

            int[] vals = new int[j - i];
            for (int k = i; k < j; k++)
                vals[k - i] = nums[order[k]];

            Arrays.sort(order, i, j);

            for (int k = i; k < j; k++)
                ans[order[k]] = vals[k - i];

            i = j;
        }
        return ans;
    }
}
```

---

**Runtime** 57 ms · **Memory** 142.2 MB

<sub>Synced by AILeetHub on 2026-08-29.</sub>
