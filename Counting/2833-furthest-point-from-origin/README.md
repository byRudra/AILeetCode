# 2833. Furthest Point From Origin

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/furthest-point-from-origin/)

`String` · `Counting`

## Intuition  
The only thing that matters is how many steps go left, how many go right, and how many steps are undecided (`_`).  
If we always move in the same direction as the majority of fixed moves, every undecided step can be used to extend that direction.  
Thus the maximum distance from the origin equals the absolute difference between the counts of `R` and `L` (the unavoidable offset) plus all the blanks that can be turned into steps in that direction.

## Approach  
1. Iterate over the string once, counting `right`, `left`, and `blank`.  
2. The unavoidable displacement is `abs(right - left)`.  
3. Every blank can be chosen to reinforce the direction that gives the larger displacement, so add `blank` to the result.  
4. Return the sum as the furthest possible distance.

## Complexity  
- **Time:** O(n) – one pass over the string of length *n*.  
- **Space:** O(1) – only three integer counters are maintained.

## Solution (python3)

```python
class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        right = 0
        left = 0
        blank = 0
        for move in moves:
            if move == 'R':
                right += 1
            elif move == 'L':
                left += 1
            else:
                blank += 1
        return abs(right - left) + blank
```

---

**Runtime** 0 ms · **Memory** 19.3 MB

<sub>Synced by AILeetHub on 2026-04-25.</sub>
