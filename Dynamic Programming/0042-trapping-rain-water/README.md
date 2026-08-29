# 42. Trapping Rain Water

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/trapping-rain-water/)

`Array` · `Two Pointers` · `Dynamic Programming` · `Stack` · `Monotonic Stack`

## Intuition  
When rain falls, the amount of water above a bar depends on the tallest bar to its left and to its right.  
If we know the maximum height seen so far from the left and from the right, we can decide which side limits the water at the current position.  
Processing the array from both ends simultaneously guarantees that at each step we use the smaller of the two boundary heights, ensuring the water level is correctly bounded.

## Approach  
Maintain two pointers, `left` at the start and `right` at the end, along with `leftMax` and `rightMax` storing the highest bars seen so far from each side.  
While `left < right`:

1. If `height[left] < height[right]`, the left side is the limiting boundary.  
   - Update `leftMax` with `max(leftMax, height[left])`.  
   - Add `leftMax - height[left]` to the total water (zero if negative).  
   - Move `left` one step right.
2. Otherwise, the right side limits the water.  
   - Update `rightMax` with `max(rightMax, height[right])`.  
   - Add `rightMax - height[right]` to the total.  
   - Move `right` one step left.

The loop ends when the pointers meet, having accumulated the trapped water for every position.

## Complexity  
- **Time:** O(n) – each bar is visited once by one of the pointers.  
- **Space:** O(1) – only a constant number of integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
```

---

**Runtime** 0 ms · **Memory** 47.7 MB

<sub>Synced by AILeetHub on 2026-08-29.</sub>
