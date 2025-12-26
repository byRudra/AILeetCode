# 2149. Rearrange Array Elements by Sign

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rearrange-array-elements-by-sign/)

`Array` · `Two Pointers` · `Simulation`

## Intuition
The array contains an equal number of positive and negative values.  
If we place the positives at indices 0, 2, 4,… and the negatives at 1, 3, 5,…, every adjacent pair will automatically have opposite signs.  
Because we scan the original array once, the relative order of positives and of negatives is preserved.

## Approach
Create a new array `result` of the same length.  
Maintain two indices: `pos` starts at 0 for the next positive slot, `neg` starts at 1 for the next negative slot.  
Iterate through `nums`:
* If the current number is non‑negative, assign it to `result[pos]` and advance `pos` by 2.
* Otherwise assign it to `result[neg]` and advance `neg` by 2.  
Return `result`.  
The algorithm runs in a single pass and uses only the output array for storage.

## Complexity
- **Time:** O(n) – one linear scan of the input array.  
- **Space:** O(n) – auxiliary array of the same size as the input.

## Solution (java)

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int []result = new int[nums.length];
        int pos = 0, neg = 1;
        for(int num : nums){
            if(num >= 0){
                result[pos] = num;
                pos += 2;
            }
            else{
                result[neg] = num;
                neg += 2;
            }
        }
        return result;
    }
}
```

---

**Runtime** 3 ms · **Memory** 175.5 MB

<sub>Synced by AILeetHub on 2025-12-26.</sub>
