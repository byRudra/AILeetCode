# 1021. Remove Outermost Parentheses

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-outermost-parentheses/)

`String` · `Stack` · `Bracket Sequences`

## Intuition  
The string is a concatenation of primitive valid parentheses.  
In each primitive, the very first '(' and the matching ')' are the outermost pair.  
All other parentheses belong to nested primitives.  
If we keep a counter of the current nesting depth while scanning left‑to‑right,  
the outermost pair is exactly the moment when depth goes from 0 to 1 (for '(') and back to 0 (for ')').  
Skipping those characters and keeping the rest yields the desired result.

## Approach  
Traverse the input once, maintaining an integer `depth`.  
* When encountering `'('`:  
  - If `depth > 0`, the parenthesis is not outermost, so append it to the result.  
  - Increment `depth`.  
* When encountering `')'`:  
  - Decrement `depth`.  
  - If `depth > 0` after the decrement, the parenthesis is not outermost, so append it.  

The `StringBuilder` collects all non‑outer parentheses in order, producing the final string.

## Complexity  
- **Time:** O(n) – each character is processed once.  
- **Space:** O(1) – only a constant‑size counter and the output builder are used.

## Solution (java)

```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder finalString = new StringBuilder("");
        int depth = 0;
        for (char current : s.toCharArray()) {
            if (current == '(') {
                if (depth > 0)
                    finalString.append(current);
                depth++;
            } else {
                depth--;
                if (depth > 0)
                    finalString.append(current);
            }
        }

        return finalString.toString();
    }
}
```

---

**Runtime** 2 ms · **Memory** 43.6 MB

<sub>Synced by AILeetHub on 2026-01-07.</sub>
