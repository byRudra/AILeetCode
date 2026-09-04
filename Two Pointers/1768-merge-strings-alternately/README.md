# 1768. Merge Strings Alternately

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-strings-alternately/)

`Two Pointers` · `String`

## Intuition  
The key observation is that the merge can be performed by scanning both strings with a single index `i` and, at each step, appending the character from `word1` (if it exists) followed immediately by the character from `word2` (if it exists). This eliminates the need for two separate pointers or a separate “turn” flag, because the presence check (`i < length`) already tells us whether a character should be taken. A naïve solution would alternate between two pointers and maintain a boolean to decide whose turn it is, which adds extra state and a second loop for the tail. By collapsing the two‑pointer alternation into one index and two conditional appends, we achieve the same result in a single pass. The pattern used here is the **two‑pointer (single‑index) traversal**.

## Approach  
1. **Initialise** a `StringBuilder result` and an integer `i = 0`.  
2. **Loop condition:** `while (i < word1.length() || i < word2.length())`.  
   - *Invariant:* before each iteration, all characters with index `< i` from both strings have already been appended to `result` in the correct alternating order.  
3. **Append from `word1`:**  
   - If `i < word1.length()`, execute `result.append(word1.charAt(i))`.  
   - This guard prevents `IndexOutOfBoundsException` when `word1` is shorter.  
4. **Append from `word2`:**  
   - If `i < word2.length()`, execute `result.append(word2.charAt(i))`.  
   - Symmetrically protects against the shorter `word2`.  
5. **Increment** `i++` to advance to the next position in both strings.  
6. **Exit** the loop when `i` has reached the end of *both* strings; at that point the invariant guarantees that `result` contains the fully merged sequence.  
7. **Return** `result.toString()`.  

Edge‑case handling:  
- Empty or single‑character strings are covered because the loop runs as long as *either* string still has characters.  
- No off‑by‑one errors: the checks use `<` (strictly less) which matches zero‑based indexing.  
- The algorithm chooses the convention “append from `word1` first” because the problem statement specifies starting with `word1`.

## Dry Run  

**Input:** `word1 = "ab", word2 = "pqrs"`

| i | result (after iteration) | note |
|---|--------------------------|------|
| 0 | "a" → then "ap"          | both strings have index 0, append `a` then `p` |
| 1 | "apb" → then "apbq"      | both strings have index 1, append `b` then `q` |
| 2 | "apbq" → then "apbqrs"   | `i` ≥ `word1.length()`, only `word2` supplies `r` and `s` |
| 3 | loop ends                | `i` (3) ≥ both lengths, exit |

Final `result` = **"apbqrs"**, which matches the required merged string because all characters from `word1` appear in order, each followed by the corresponding character from `word2` when available, and the remaining tail of the longer string is appended.

## Complexity  
- **Time:** O(n + m) – the loop iterates `max(word1.length(), word2.length())` times, performing constant‑time appends each pass.  
- **Space:** O(n + m) – the `StringBuilder` stores the output of length `n + m`; auxiliary space is O(1) besides the builder.

## Solution (Java)

```java
// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         String result = "";
//         int i = 0, j = 0;
//         boolean turnWord = true;
//         while (i < word1.length() && j < word2.length()) {
//              if (turnWord) {
//                 result += word1.charAt(i);
//                 i++;
//             } else {
//                 result += word2.charAt(j);
//                 j++;
//             }

//             turnWord = !turnWord;
//         }
//         while (i < word1.length()) {
//             result += word1.charAt(i);
//             i++;
//         }
//         while (j < word2.length()) {
//             result += word2.charAt(j);
//             j++;
//         }
//         return result;
//     }
// }

//Better approach
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < word1.length() || i < word2.length()) {

            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }

            i++;
        }

        return result.toString();
    }
}
```

---

**Runtime** 1 ms (beats 96.1%) · **Memory** 42.8 MB (beats 89.1%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
