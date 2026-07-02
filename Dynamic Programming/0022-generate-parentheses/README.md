# 22. Generate Parentheses

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/generate-parentheses/)

`String` · `Dynamic Programming` · `Backtracking` · `Bracket Sequences`

## Intuition  
To form a well‑formed string of `n` pairs, at any point the number of closing brackets cannot exceed the number of opening ones.  
The task is to explore all sequences that respect this invariant until the string reaches length `2n`.

## Approach  
A depth‑first search builds the string character by character.  
The recursive helper keeps three pieces of state:  
* `current` – the string built so far  
* `open` – how many `'('` have been added  
* `close` – how many `')'` have been added  

When `current.length()` equals `2n`, a complete valid sequence is found and added to the result list.  
Otherwise two decisions are possible:  
1. If `open < n`, append `'('` and recurse.  
2. If `close < open`, append `')'` and recurse.  

These two branches guarantee that every generated string is balanced and that all balanced strings are produced.

## Complexity  
- **Time:** O(Cₙ · n) – each of the Catalan‑number `Cₙ` valid sequences is generated once, and building a sequence takes `O(n)` time.  
- **Space:** O(n) – recursion depth never exceeds `2n`, and the auxiliary space aside from the result list is linear in `n`.

## Solution (java)

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {
        if(current.length() == 2*n){
            result.add(current);
            return;
        }
        if(open < n){
            backtrack(result, current + "(", open+1, close, n);
        }
        if(close < open){
            backtrack(result, current + ")", open, close+1, n);
        }
    }
}
```

---

**Runtime** 2 ms · **Memory** 44.4 MB

<sub>Synced by AILeetHub on 2026-07-02.</sub>
