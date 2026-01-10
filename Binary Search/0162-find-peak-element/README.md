# 162. Find Peak Element

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-peak-element/)

`Array` · `Binary Search`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Binary Search.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.5 MB

<sub>Synced by AILeetHub on 2026-01-10.</sub>
