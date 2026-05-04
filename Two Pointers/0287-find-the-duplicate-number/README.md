# 287. Find the Duplicate Number

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-duplicate-number/)

`Array` · `Two Pointers` · `Binary Search` · `Bit Manipulation` · `Pigeonhole Principle` · `Floyd's Cycle Finding Algorithm`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Binary Search, Bit Manipulation, Pigeonhole Principle, Floyd's Cycle Finding Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int arr[] = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] > 1)
                return i;
        }
        return -1;

    }
}
```

---

**Runtime** 2 ms · **Memory** 81 MB

<sub>Synced by AILeetHub on 2026-05-04.</sub>
