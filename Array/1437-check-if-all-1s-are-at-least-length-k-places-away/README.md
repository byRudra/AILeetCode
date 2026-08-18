# 1437. Check If All 1's Are at Least Length K Places Away

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/)

`Array`

## Intuition  
The only information needed to decide whether a new `1` is too close to a previous one is the index of the last seen `1`.  
If the distance between consecutive `1`s (in terms of indices) is at least `k+1`, then the number of zeros between them is at least `k`.  
Thus, by remembering the position of the last `1` we can check each new `1` in constant time.

## Approach  
1. Initialise `last` to `-1` to indicate that no `1` has been seen yet.  
2. Scan the array from left to right.  
3. When a `1` is encountered:  
   * If `last` is not `-1`, compute the gap `i - last - 1`.  
   * If this gap is smaller than `k`, the condition is violated – return `false`.  
   * Otherwise, update `last` to the current index.  
4. If the loop finishes without returning `false`, all `1`s satisfy the spacing requirement – return `true`.

The algorithm uses a single pass and constant extra space.

## Complexity  
- **Time:** O(n) – each element is inspected once.  
- **Space:** O(1) – only a few integer variables are stored regardless of input size.

## Solution (java)

```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last != -1 && i - last - 1 < k)
                    return false;
                last = i;
            }

        }
        return true;
    }
}
```

---

**Runtime** 1 ms · **Memory** 65.8 MB

<sub>Synced by AILeetHub on 2026-08-18.</sub>
