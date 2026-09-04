# 1768. Merge Strings Alternately

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-strings-alternately/)

`Two Pointers` · `String`

## Intuition  
When we walk through both strings simultaneously, each step consumes exactly one character from the string whose turn it is. Because the turn flips after every character, the two pointers `i` and `j` stay perfectly synchronized with the alternating pattern. A naïve solution might concatenate the whole first string, then splice the second one character by character, which would require extra passes or index arithmetic. The observation that a single boolean flag (`turnWord`) can dictate which pointer to advance eliminates any need for a second pass or auxiliary data structures, yielding a classic two‑pointer interleaving.

## Approach  
1. **Initialize** `result` as an empty string, `i = 0`, `j = 0`, and `turnWord = true` (meaning the next character must come from `word1`).  
2. **Main interleaving loop** – `while (i < word1.length() && j < word2.length())`  
   - *Invariant*: before each iteration, `result` already contains the correctly interleaved prefix of length `i + j`.  
   - If `turnWord` is `true`, append `word1.charAt(i)` to `result` and increment `i`; otherwise append `word2.charAt(j)` and increment `j`.  
   - Flip `turnWord` (`turnWord = !turnWord`) so the next iteration takes the opposite string.  
   - The loop exits as soon as one of the strings is exhausted, guaranteeing that no index out‑of‑bounds occurs.  
3. **Residual characters from `word1`** – `while (i < word1.length())`  
   - Append the remaining characters of `word1` one by one. This handles the case where `word1` is longer; the loop condition ensures we stop exactly at the end.  
4. **Residual characters from `word2`** – `while (j < word2.length())`  
   - Symmetrically append any leftover characters of `word2`.  
5. **Return** the built `result`.  

Edge cases:  
- If either input is empty, the main loop never runs and the appropriate residual loop copies the non‑empty string.  
- The `<=` vs `<` choice is irrelevant here because we compare indices against `length()`, which is exclusive; using `<` correctly prevents off‑by‑one errors.  

## Dry Run  

**Input**: `word1 = "ab"`, `word2 = "pqrs"`

| Iteration | i | j | turnWord | result | Change |
|-----------|---|---|----------|--------|--------|
| 0 (init)  | 0 | 0 | true     | ""     | – |
| 1         | 1 | 0 | false    | "a"    | took `a` from `word1` |
| 2         | 1 | 1 | true     | "ap"   | took `p` from `word2` |
| 3         | 2 | 1 | false    | "apb"  | took `b` from `word1` |
| 4         | 2 | 2 | true     | "apbq" | took `q` from `word2` (main loop ends, `i==2`) |
| 5         | 2 | 3 | –        | "apbqr"| residual loop on `word2` adds `r` |
| 6         | 2 | 4 | –        | "apbqrs"| residual loop on `word2` adds `s` |

The main loop stops when `i` reaches `word1.length()`. The remaining two characters of `word2` are appended by the second residual loop, yielding the final merged string `"apbqrs"`.

## Complexity  
- **Time:** O(n + m) – each character of `word1` (length *n*) and `word2` (length *m*) is visited exactly once by the three while loops.  
- **Space:** O(1) extra – only a few integer counters and a boolean flag are used; the output string itself is not counted against the auxiliary space budget.

## Solution (Java)

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int i = 0, j = 0;
        boolean turnWord = true;
        while (i < word1.length() && j < word2.length()) {
             if (turnWord) {
                result += word1.charAt(i);
                i++;
            } else {
                result += word2.charAt(j);
                j++;
            }

            turnWord = !turnWord;
        }
        while (i < word1.length()) {
            result += word1.charAt(i);
            i++;
        }
        while (j < word2.length()) {
            result += word2.charAt(j);
            j++;
        }
        return result;
    }
}
```

---

**Runtime** 4 ms (beats 19.8%) · **Memory** 44 MB (beats 11.0%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
