# 3702. Longest Subsequence With Non-Zero Bitwise XOR

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/)

`Array` · `Bit Manipulation`

## Intuition  
The XOR of a subsequence equals the XOR of all its elements.  
If the XOR of the entire array is already non‑zero, the whole array is a valid subsequence.  
When the total XOR is zero, the only way to obtain a non‑zero XOR is to remove at least one element.  
Removing a zero does not change the XOR, so we must remove a non‑zero element.  
If every element is zero, no subsequence can have a non‑zero XOR.

## Approach  
1. Iterate once over `nums`, computing the cumulative XOR (`xor`) and checking whether any element is non‑zero (`contains`).  
2. If `xor` ≠ 0, return `nums.length`.  
3. If `xor` == 0 but `contains` is true, return `nums.length - 1` (drop one non‑zero element).  
4. Otherwise all elements are zero; return 0.

The algorithm exploits the fact that XOR is associative and that removing a zero keeps the XOR unchanged, while removing a non‑zero element flips the XOR from zero to non‑zero.

## Complexity  
- **Time:** O(n) – one pass through the array.  
- **Space:** O(1) – only a few integer variables are used.

## Solution (java)

```java
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean contains = false;
        for(int num : nums){
            xor ^= num;
            if(num != 0){
                contains = true;
            }
        }
        if(xor != 0) return nums.length;
        if(contains)
            return nums.length - 1;
        return 0;
    }
}
```

---

**Runtime** 2 ms · **Memory** 133.3 MB

<sub>Synced by AILeetHub on 2026-08-16.</sub>
