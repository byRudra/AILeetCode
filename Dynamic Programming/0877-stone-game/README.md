# 877. Stone Game

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/stone-game/)

`Array` · `Math` · `Dynamic Programming` · `Minimax` · `Game Theory` · `Zero-Sum Game`

## Intuition
Because the number of piles is even and the total number of stones is odd, the game is a zero‑sum game with a guaranteed winner.  
Alice can always force a win by choosing the pile that matches the parity of the remaining piles after Bob’s move.  
In other words, after Bob picks a pile, the remaining piles are again an even number, and Alice can mirror Bob’s strategy to keep the advantage.  
This parity argument shows that Alice’s optimal play will always yield more stones than Bob’s, regardless of the actual values in `piles`.

## Approach
The solution leverages the proven theoretical result: *Alice always wins when both play optimally.*  
Thus the implementation is trivial: simply return `true`. No simulation, DP, or recursion is needed because the outcome is predetermined by the game’s constraints.

## Complexity
- **Time:** O(1) – a single boolean return.  
- **Space:** O(1) – no additional data structures are used.

## Solution (java)

```java
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43 MB

<sub>Synced by AILeetHub on 2026-08-02.</sub>
