# 153. Find Minimum in Rotated Sorted Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

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
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-09-01.</sub>
