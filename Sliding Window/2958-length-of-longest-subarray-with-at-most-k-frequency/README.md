# 2958. Length of Longest Subarray With at Most K Frequency

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)

`Array` · `Hash Table` · `Sliding Window`

## Intuition
A subarray is “good” as long as no element appears more than k times.  
When scanning the array from left to right, adding a new element can only break the condition if its frequency becomes k + 1.  
Thus we can keep a sliding window that always satisfies the constraint: expand the right end, and if the newly added element violates the rule, contract the left end until the violation disappears again.

## Approach
Use two pointers `i` (left) and `j` (right) to delimit the current window.  
Maintain a hash map `m` that records the frequency of each value inside the window.  
For each `j`:
1. Increment the count of `nums[j]` in `m`.  
2. While `m.get(nums[j]) > k`, decrement the count of `nums[i]` and move `i` right.  
   This loop guarantees that after it finishes, the window contains no element with frequency exceeding k.  
3. Update the answer with the current window size `j - i + 1`.  
Move `j` forward and repeat until the end of the array.  
The map is updated in constant time per element, and each index is visited at most twice (once by `j`, once by `i`).

## Complexity
- **Time:** O(n) – each element is processed by the right pointer once and possibly by the left pointer once.  
- **Space:** O(m) – the hash map stores at most one entry per distinct value in the current window.

## Solution (java)

```java
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();

        int i = 0, j = 0;
        int res = 0;

        while (j < nums.length) {
            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);

            while (m.get(nums[j]) > k) {
                m.put(nums[i], m.get(nums[i]) - 1);
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
```

---

**Runtime** 65 ms · **Memory** 89.1 MB

<sub>Synced by AILeetHub on 2026-08-12.</sub>
