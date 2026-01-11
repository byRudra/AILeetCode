# 704. Binary Search

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-search/)

`Array` · `Binary Search`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Binary Search.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2; 
            if(target == nums[mid]) return mid;
            else if (nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        return -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 48.6 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
