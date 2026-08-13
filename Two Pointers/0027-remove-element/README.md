# 27. Remove Element

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-element/)

`Array` · `Two Pointers`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.6 MB

<sub>Synced by AILeetHub on 2026-08-13.</sub>
