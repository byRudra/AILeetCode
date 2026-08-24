# 1872. Stone Game VIII

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/stone-game-viii/)

`Array` · `Math` · `Dynamic Programming` · `Minimax` · `Prefix Sum` · `Game Theory` · `Zero-Sum Game`

## Intuition
The game can be seen as a zero‑sum process on the prefix sums of the stones.  
When a player removes the first *x* stones, the value added to his score is exactly the sum of that prefix.  
After the move the remaining row starts with a single stone whose value equals that prefix sum.  
Thus the future of the game depends only on the prefix sum that becomes the new leftmost stone.  
If we denote by `S[i]` the sum of the first `i+1` stones, the optimal score difference after the first `i+1` stones have been processed can be expressed recursively in terms of the best difference achievable from the remaining suffix.

## Approach
1. **Prefix sums** – Convert the array into cumulative sums `S`.  
   `S[i] = stones[0] + … + stones[i]`.  
2. **Dynamic evaluation** – Starting from the end, maintain a variable `best` that stores the maximum score difference achievable from the current position.  
   For each `i` from `n-2` down to `1`:
   - If the current player takes the first `i+1` stones, the resulting difference is `S[i] - best` (the opponent will then play optimally, giving `best`).  
   - Update `best = max(best, S[i] - best)`.  
3. The final answer is `best`, which represents the optimal difference when the whole array is considered.

## Complexity
- **Time:** O(n) – one pass to build prefix sums and one reverse pass to compute the optimal difference.  
- **Space:** O(1) – the prefix sums are stored in the original array and only a few scalar variables are used.

## Solution (java)

```java
class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }
        int best = stones[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, stones[i] - best);
        }
        return best;
    }
}
```

---

**Runtime** 3 ms · **Memory** 83.1 MB

<sub>Synced by AILeetHub on 2026-08-24.</sub>
