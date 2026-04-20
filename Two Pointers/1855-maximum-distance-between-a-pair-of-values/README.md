# 1855. Maximum Distance Between a Pair of Values

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/)

`Array` · `Two Pointers` · `Binary Search`

## Intuition  
Both arrays are sorted in non‑increasing order.  
For a fixed index `i` in `nums1`, the largest valid `j` must be the farthest position in `nums2` where `nums1[i] ≤ nums2[j]`.  
Because `nums2` only decreases, once a position fails the inequality, all later positions will also fail.  
Thus we can scan the two arrays simultaneously, moving the right pointer `j` forward until the inequality breaks, then advance `i` to try the next element of `nums1`.

## Approach  
Start with `i = 0` and `j = 0`.  
While both indices are within bounds and `i ≤ j`:

1. If `nums1[i] ≤ nums2[j]`, the pair `(i, j)` is valid.  
   Update `maxDistance` with `j - i` and move `j` forward to search for a farther match.
2. If the inequality fails, the current `i` cannot pair with any later `j` (because `nums2` only decreases).  
   Increment both `i` and `j` to test the next element of `nums1`.

The loop ends when either array is exhausted or `i` surpasses `j`.  
The maximum distance found during the scan is returned.

## Complexity  
- **Time:** O(n + m) – each pointer moves at most once through its array.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (python3)

```python
class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        maxDistance = 0
        i = 0
        j = 0
        while(i <= j and i < len(nums1) and j < len(nums2)):
            if nums1[i] <= nums2[j]:
                maxDistance = max(maxDistance, j - i)
                j += 1
            else:
                j += 1
                i += 1

        return maxDistance
```

---

**Runtime** 41 ms · **Memory** 36 MB

<sub>Synced by AILeetHub on 2026-04-20.</sub>
