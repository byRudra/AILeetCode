# 2126. Destroying Asteroids

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/destroying-asteroids/)

`Array` · `Greedy` · `Sorting`

## Intuition
The planet grows only by defeating asteroids that are not heavier than its current mass. To maximize the chance of survival, we should always attack the lightest remaining asteroid first; this gives the planet the smallest possible mass increase while still being survivable. If the planet can defeat the smallest asteroid, it can subsequently defeat all heavier ones in order.

## Approach
1. Sort the `asteroids` array in non‑decreasing order.  
2. Keep a `currentMass` variable (use `long` to avoid overflow).  
3. Iterate through the sorted array:  
   * If `currentMass < asteroid`, the planet cannot destroy it → return `false`.  
   * Otherwise, add the asteroid’s mass to `currentMass`.  
4. If the loop completes, all asteroids were destroyed → return `true`.

## Complexity
- **Time:** O(n log n) – sorting dominates; the linear scan is O(n).  
- **Space:** O(1) – only a few variables are used; sorting is performed in place.

## Solution (java)

```java
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }

        return true;
    }
}
```

---

**Runtime** 26 ms · **Memory** 107.4 MB

<sub>Synced by AILeetHub on 2026-05-31.</sub>
