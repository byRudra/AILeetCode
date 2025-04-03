# 88. Merge Sorted Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-sorted-array/)

`Array` · `Two Pointers` · `Sorting`

## Intuition
The two input arrays are already sorted. By starting from the back of each array we can place the largest remaining element directly into the last free slot of `nums1`. This avoids overwriting elements that have not yet been examined and eliminates the need for an auxiliary array.

## Approach
1. Initialize three indices:  
   * `p1` at the last valid element of `nums1` (`m‑1`).  
   * `p2` at the last element of `nums2` (`n‑1`).  
   * `p` at the very end of `nums1` (`m+n‑1`).
2. While both `p1` and `p2` are non‑negative, compare `nums1[p1]` and `nums2[p2]`.  
   * Place the larger value at `nums1[p]`.  
   * Decrement the pointer that supplied the value and also decrement `p`.
3. After the loop, if any elements remain in `nums2` (`p2` ≥ 0), copy them into the front of `nums1`.  
   Elements already in place from `nums1` need no action because they are already correctly positioned.

## Complexity
- **Time:** O(m + n) – each element is examined once while merging.  
- **Space:** O(1) – only a few integer indices are used, no extra arrays.

## Solution (java)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;

        while(p1 >= 0 && p2 >= 0){
            int element1, element2;
            element1 = (p1 >= 0) ? nums1[p1] : Integer.MIN_VALUE;
            element2 = (p2 >= 0) ? nums2[p2] : Integer.MIN_VALUE;
            if (element1 > element2){
                nums1[p] = element1;
                p1--;
            }
            else{
                nums1[p] = element2;
                p2--;
            }
            p--;


        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }

    }
}
```

---

**Runtime** 0 ms · **Memory** 42.4 MB

<sub>Synced by AILeetHub on 2025-04-03.</sub>
