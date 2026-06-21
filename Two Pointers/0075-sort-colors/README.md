# 75. Sort Colors

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sort-colors/)

`Array` · `Two Pointers` · `Sorting` · `Quicksort` · `Bubble Sort`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Sorting, Quicksort, Bubble Sort.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++;
            } 
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.7 MB

<sub>Synced by AILeetHub on 2026-06-21.</sub>
