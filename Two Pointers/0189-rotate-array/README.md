# 189. Rotate Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-array/)

`Array` · `Math` · `Two Pointers`

## Intuition  
If we reverse the whole array, the elements that should end up at the front are now at the back but in reversed order, and the elements that should stay at the back are at the front, also reversed. Reversing each of those two segments individually restores their internal order while preserving the overall rotation. This observation eliminates the need for an auxiliary array or multiple passes that copy elements one‑by‑one. The pattern used is the classic **three‑reverse in‑place rotation**.

## Approach  
1. **Normalize `k`.**  
   ```java
   k = k % length;
   ```  
   When `k` equals the array length or a multiple thereof the array is unchanged, so we reduce `k` to the minimal effective shift.  

2. **Reverse the entire array.**  
   Call `reverse(nums, 0, length‑1)`.  
   *Loop invariant:* before each iteration `nums[start…end]` is the segment still to be swapped; after swapping `start` and `end` the invariant holds for the narrowed segment (`start++`, `end--`). The loop exits when `start >= end`.  

3. **Reverse the first `k` elements.**  
   Call `reverse(nums, 0, k‑1)`.  
   The same invariant applies, now limited to the prefix that should appear at the front after rotation.  

4. **Reverse the remaining `length‑k` elements.**  
   Call `reverse(nums, k, length‑1)`.  
   Again the invariant guarantees that after the loop the suffix is in correct order.  

Edge cases handled explicitly:  
- `k == 0` (or `k % length == 0`) leads to a no‑op because the three reversals become a full reverse followed by two reverses of the whole array, which cancel out.  
- Single‑element arrays: `length == 1` makes every `reverse` call a no‑op because `start == end`.  

## Dry Run  
Input: `nums = [1,2,3,4,5,6,7]`, `k = 3`  

| Step | start | end | nums (after iteration) | Note |
|------|-------|-----|------------------------|------|
| 1. Normalize | – | – | k = 3 (3 % 7) | |
| 2. Reverse whole array | 0 | 6 | [7,6,5,4,3,2,1] | swap 0↔6, 1↔5, 2↔4 |
| 3. Reverse first k (0‑2) | 0 | 2 | [5,6,7,4,3,2,1] | swap 0↔2 |
| 4. Reverse rest (3‑6) | 3 | 6 | [5,6,7,1,2,3,4] | swap 3↔6, 4↔5 |

Final state `[5,6,7,1,2,3,4]` matches a right rotation by three positions.

## Complexity  
- **Time:** `O(n)` – each of the three `reverse` calls scans its segment once, together touching every element exactly three times.  
- **Space:** `O(1)` – the algorithm rearranges the array in place, using only a few integer variables for indices and a temporary swap variable. (The output array is the input itself, so no extra storage is counted.)

## Solution (Java)

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

**Runtime** 0 ms (beats 100.0%) · **Memory** 61.4 MB (beats 52.9%)

<sub>Synced by AILeetHub on 2026-01-11.</sub>
