# 1004. Max Consecutive Ones III

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones-iii/)

`Array` · `Binary Search` · `Sliding Window` · `Prefix Sum`

## Intuition  
The goal is to find the longest subarray that can contain at most **k** zeros after flipping them to ones.  
If we look at any subarray, the number of zeros inside it is the only thing that limits its length.  
Thus, we can keep a sliding window that always satisfies “zeros ≤ k” and grow it as far as possible.

## Approach  
Traverse the array with a right pointer `r`.  
* When `nums[r]` is 0, increment a counter `zero`.  
* While `zero` exceeds `k`, move the left pointer `l` rightwards, decrementing `zero` whenever a 0 is left behind.  
* After each adjustment, the window `[l, r]` contains at most `k` zeros, so it is a valid candidate.  
* Update the answer with the current window length `r - l + 1`.  
Because each index is visited at most twice (once by `r`, once by `l`), the algorithm runs in linear time.

## Complexity  
- **Time:** O(n) – each element is processed a constant number of times.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, ans = 0, zero = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)
                zero++;

            while (zero > k) {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
```

---

**Runtime** 3 ms · **Memory** 52.4 MB

<sub>Synced by AILeetHub on 2026-07-17.</sub>
