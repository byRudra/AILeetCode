# 11. Container With Most Water

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/container-with-most-water/)

`Array` · `Two Pointers` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;

        while(start < end){
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if(height[start] > height[end])
                end--;
            else
                start++;
        }
        return maxArea;
    }
}
```

---

**Runtime** 5 ms · **Memory** 77.4 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
