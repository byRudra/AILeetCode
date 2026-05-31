# 2540. Minimum Common Value

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-common-value/)

`Array` · `Hash Table` · `Two Pointers` · `Binary Search`

## Intuition  
Both arrays are sorted, so any common element must appear in the same relative order in each list.  
If we walk through the arrays simultaneously, we can skip over values that are too small in one array without missing a potential match.

## Approach  
Use two indices, `i` for `nums1` and `j` for `nums2`.  
While neither index has reached the end of its array:  
1. If `nums1[i] == nums2[j]`, the current value is the smallest common element (because we traverse in ascending order), so return it.  
2. If `nums1[i] > nums2[j]`, increment `j` to catch up.  
3. Otherwise, increment `i`.  
If the loop finishes without finding a match, return `-1`.

This is a classic two‑pointer scan that exploits the sorted property to avoid nested loops or extra data structures.

## Complexity  
- **Time:** O(n + m) – each element of both arrays is examined at most once.  
- **Space:** O(1) – only two integer indices are used, regardless of input size.

## Solution (java)

```java
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return -1;
    }
}
```

---

**Runtime** 2 ms · **Memory** 80.2 MB

<sub>Synced by AILeetHub on 2026-05-31.</sub>
