# 1927. Sum Game

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sum-game/)

`Math` · `String` · `Greedy` · `Game Theory`

## Intuition  
The game ends when all '?' are replaced.  
Let `S1` and `S2` be the sums of the known digits in the left and right halves, and `Q1`, `Q2` the counts of '?' in each half.  
If the total number of '?' is odd, Alice can always force an odd number of moves, leaving Bob unable to balance the two sums – she wins.  
When the total is even, the game reduces to whether Bob can adjust the difference `S1‑S2` to zero using the remaining '?'.

## Approach  
1. Scan the string once, accumulating `S1`, `S2`, `Q1`, and `Q2`.  
2. If `(Q1+Q2)` is odd, return `true` (Alice wins).  
3. Otherwise, Bob can change the difference by at most `9` per '?' in the right half and at least `0` per '?' in the left half.  
   The only way Bob can make the sums equal is if the initial difference can be cancelled by the maximum possible adjustment:  
   `2*(S1‑S2) == 9*(Q2‑Q1)`.  
   If this equality holds, Bob can win; otherwise Alice wins.  
The code implements exactly this logic.

## Complexity  
- **Time:** O(n) – one linear scan of the string.  
- **Space:** O(1) – only a few integer counters are maintained.

## Solution (java)

```java
class Solution {
    public boolean sumGame(String num) {
        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (i < num.length() / 2) {
                if (ch == '?')
                    q1++;
                else
                    sum1 += ch - '0';
            } else {
                if (ch == '?')
                    q2++;
                else
                    sum2 += ch - '0';
            }
        }
        if ((q1 + q2) % 2 == 1)
            return true;
        return 2 * (sum1 - sum2) != 9 * (q2 - q1);
    }
}
```

---

**Runtime** 10 ms · **Memory** 47.1 MB

<sub>Synced by AILeetHub on 2026-08-23.</sub>
