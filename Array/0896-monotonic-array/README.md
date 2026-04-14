# 896. Monotonic Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/monotonic-array/)

`Array`

## Intuition  
A monotonic array must never change direction.  
If we can confirm that the array never decreases, it is monotone increasing.  
If that fails, we only need to check that it never increases; if that also fails, the array is not monotonic.

## Approach  
1. Assume the array is increasing (`isAsc = true`).  
2. Scan once from the second element to the end.  
   * If any element is smaller than its predecessor, the array cannot be increasing; set `isAsc = false` and stop the scan.  
3. If the first scan succeeded (`isAsc` remains true), return `true`.  
4. Otherwise, scan again from the second element.  
   * If any element is larger than its predecessor, the array cannot be decreasing; return `false`.  
5. If the second scan completes without finding an increase, the array is monotone decreasing, so return `true`.

This two‑pass strategy guarantees that we only traverse the array twice in the worst case, and we stop early if an increasing or decreasing violation is found.

## Complexity  
- **Time:** O(n) – each element is examined at most twice.  
- **Space:** O(1) – only a few boolean variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isAsc = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){ 
                isAsc = false;
                break;
            }
        }
        if (isAsc == true) return true; 
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){ 
                return false;
            }
        }
        return true;
    }
}
```

---

**Runtime** 1 ms · **Memory** 85 MB

<sub>Synced by AILeetHub on 2026-04-14.</sub>
