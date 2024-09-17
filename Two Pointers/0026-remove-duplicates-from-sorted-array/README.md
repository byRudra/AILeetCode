# 26. Remove Duplicates from Sorted Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

`Array` · `Two Pointers`

## Intuition  
Because the array is sorted, duplicates appear consecutively.  
If we keep a pointer to the last unique element’s position, every time we encounter a new value we can overwrite the next slot.  
Thus we can transform the array in one pass while preserving order.

## Approach  
1. Start a write index `x` at 1 (the second position).  
2. Scan the array from the second element (`i = 1`) to the end.  
3. For each `i`, compare `nums[i]` with its predecessor `nums[i‑1]`.  
   * If they differ, assign `nums[x] = nums[i]` and increment `x`.  
   * If they are equal, skip—`x` remains unchanged.  
4. After the loop, `x` equals the number of distinct values `k`.  
5. Return `k`; the first `k` elements of `nums` now hold the unique values in sorted order.

## Complexity  
- **Time:** O(n) – a single linear scan over the array.  
- **Space:** O(1) – only a few integer variables are used, regardless of input size.

## Solution (cpp)

```cpp
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int x = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[x++] = nums[i];
            }
        }
        return x;
    }
};
```

---

**Runtime** 6 ms · **Memory** 21.4 MB

<sub>Synced by AILeetHub on 2024-09-17.</sub>
