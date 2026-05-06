# 1752. Check if Array Is Sorted and Rotated

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)

`Array`

## Intuition  
A non‑decreasing array that has been rotated will still be mostly sorted.  
If you walk around the array once, you will see the order break only at the point where the rotation happened.  
Thus, in a valid rotated sorted array there can be **at most one** index `i` such that `nums[i] > nums[(i+1) % n]`.  
Any additional break means the array cannot come from a single rotation of a sorted list.

## Approach  
Traverse the array once, comparing each element with its successor (using modulo to wrap around).  
Maintain a counter that increments whenever the current element is greater than the next one.  
After the loop, if the counter is `0` (already sorted) or `1` (exactly one rotation point), return `true`; otherwise return `false`.  
The algorithm naturally handles duplicates because a duplicate pair never triggers a decrease.

## Complexity  
- **Time:** O(n) – a single pass over the array.  
- **Space:** O(1) – only an integer counter is used, independent of input size.

## Solution (java)

```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;  

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[(i + 1) % nums.length]) count++;
        }

        return count <= 1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.2 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
