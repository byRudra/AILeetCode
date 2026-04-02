# 292. Nim Game

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/nim-game/)

`Math` · `Brainteaser` · `Minimax` · `Game Theory` · `Nim Game` · `Impartial Game`

## Intuition
In this Nim variant each player can take 1–3 stones.  
If the remaining stones are a multiple of 4, whatever the current player removes (1, 2, or 3), the opponent can always take the complementary number to bring the total back to a multiple of 4.  
Thus the player who faces a multiple of 4 is forced into a losing position if the opponent plays optimally.  
Conversely, if the pile size is not a multiple of 4, the first player can remove enough stones to leave a multiple of 4 to the opponent, guaranteeing a win.

## Approach
The solution implements this observation directly: compute `n % 4`.  
If the remainder is zero, return `false` (first player loses); otherwise return `true`.  
No recursion or dynamic programming is needed because the pattern repeats every four stones.

## Complexity
- **Time:** O(1) – a single modulo operation and comparison.  
- **Space:** O(1) – only a constant amount of extra memory is used.

## Solution (java)

```java
class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0) ? true : false;

    }
}
```

---

**Runtime** 0 ms · **Memory** 41.8 MB

<sub>Synced by AILeetHub on 2026-04-02.</sub>
