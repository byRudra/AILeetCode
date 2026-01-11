# 189. Rotate Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-array/)

`Array` · `Math` · `Two Pointers`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Math, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
// class Solution {
//     public void rotate(int[] nums, int k) {
//         if (k == 0) return;
//         int res [] = new int[nums.length];
//         for(int i = 0; i < nums.length; i++){
//                 // 1 2 3 4 rotate 2 times
//                 // 4 1 2 3 
//                 // 3 4 1 2
//                 int newIndex = (i + k) % nums.length;
//                 res[newIndex] = nums[i];
//             }
//         for(int i = 0; i < nums.length; i++){
//             nums[i] = res[i];
//         }
//     }
// }

// better approach

class Solution{
    public void rotate(int []nums, int k){
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , length - 1);


    }
    private void reverse(int[]nums,int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
    }
}
```

---

**Runtime** 0 ms · **Memory** 61.4 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
