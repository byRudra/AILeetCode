# 3903. Smallest Stable Index I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-stable-index-i/)

`Array` · `Prefix Sum`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// O(n ^ 2)
// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int max = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             int min = nums[i];
//             max = Math.max(max, nums[i]);
//             for (int j = i + 1; j < nums.length; j++) {
//                 min = Math.min(min, nums[j]);
//             }
//             if (max - min <= k)
//                 return i;
//         }
//         return -1;
//     }
// }

// O(n)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
       int n = nums.length;
       // calculate min suffix for each with a backward pass 

       int suffixMin[] = new int[nums.length];
       suffixMin[n - 1] = nums[n - 1];
       for(int i = n - 2; i >= 0; i--){
        suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]); 
       } 
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
        max = Math.max(max, nums[i]);
        if(max - suffixMin[i] <= k) return i;
       }
       return - 1;
    }
}
```

---

**Runtime** 1 ms · **Memory** 46.3 MB

<sub>Synced by AILeetHub on 2026-09-04.</sub>
