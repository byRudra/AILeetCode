# 33. Search in Rotated Sorted Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/)

`Array` · `Binary Search`

## Intuition
A rotated sorted array still contains two contiguous sorted sub‑arrays.  
At any step of binary search we can determine which half is properly sorted by comparing the boundary values.  
If the target lies within the sorted half, we discard the other half; otherwise we keep the unsorted half.  
This guarantees that the search interval shrinks by roughly half each iteration, giving logarithmic time.

## Approach
1. Initialize `start = 0` and `end = nums.length‑1`.  
2. While `start <= end`:
   * Compute `mid = start + (end - start)/2`.  
   * If `nums[mid]` equals the target, return `mid`.  
   * Check if the left side `[start…mid]` is sorted (`nums[start] <= nums[mid]`).  
     * If sorted and the target is between `nums[start]` and `nums[mid]`, move `end` to `mid‑1`.  
     * Otherwise move `start` to `mid+1`.  
   * If the left side isn’t sorted, the right side `[mid…end]` must be sorted.  
     * If the target is between `nums[mid]` and `nums[end]`, move `start` to `mid+1`.  
     * Otherwise move `end` to `mid‑1`.  
3. If the loop ends, the target is absent; return `-1`.

## Complexity
- **Time:** O(log n) – each iteration halves the search interval.  
- **Space:** O(1) – only a few integer variables are used.

## Solution (java)

```java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                 if(target  <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
