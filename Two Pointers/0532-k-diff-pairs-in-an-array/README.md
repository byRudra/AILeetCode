# 532. K-diff Pairs in an Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

`Array` · `Hash Table` · `Two Pointers` · `Binary Search` · `Sorting`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Two Pointers, Binary Search, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// class Solution {
//     public int findPairs(int[] nums, int k) {
//         HashSet<String> set = new HashSet<>();

//         for(int i = 0; i < nums.length; i++){
//             for(int j = i + 1; j < nums.length; j++){
//                 if(i == j) continue;

//                 if(Math.abs(nums[i] - nums[j]) == k){
//                     int a  = Math.min(nums[i], nums[j]);
//                     int b  = Math.max(nums[i], nums[j]);
//                     set.add(a + "," + b);
//                 }
//             }
//         }
//         return set.size();
//     }
// }

// Optimal Scene
class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> pairs = new HashSet<>();

        for(int num : nums){
            if(seen.contains(num - k)){
                pairs.add(num - k);
            }
            if(seen.contains(num + k)){
                pairs.add(num);
            }
            seen.add(num);
        }
        return pairs.size();
    }
}
```

---

**Runtime** 10 ms · **Memory** 47.6 MB

<sub>Synced by AILeetHub on 2026-08-29.</sub>
