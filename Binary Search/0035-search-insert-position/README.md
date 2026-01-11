# 35. Search Insert Position

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/search-insert-position/)

`Array` · `Binary Search`

## Intuition  
The array is sorted, so a binary search can locate the target or determine where it would fit.  
If the target exists, its index is returned immediately.  
If it does not exist, the algorithm keeps narrowing the search window until the window collapses to a single position – the insertion point.

## Approach  
Initialize two pointers: `left` at the start and `right` at the array’s length.  
While `left < right`, compute `mid` as the floor of the average of `left` and `right`.  
* If `nums[mid]` equals the target, return `mid`.  
* If `nums[mid]` is greater than the target, the target must lie to the left, so set `right = mid`.  
* Otherwise, the target lies to the right, so set `left = mid + 1`.  
When the loop ends, `left` equals the smallest index where the target could be inserted while preserving order. Return `left`.

## Complexity  
- **Time:** O(log n) – each iteration halves the search interval.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.9 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
