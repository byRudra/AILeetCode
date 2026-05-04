# 796. Rotate String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-string/)

`String` · `String Matching`

## Intuition
A rotation of a string can be visualised as taking a prefix and appending it to the suffix.  
If we concatenate the original string with itself (`s + s`), every possible rotation of `s` appears as a contiguous substring of this doubled string. Therefore, to determine whether `goal` is a rotation of `s`, it suffices to check whether `goal` occurs inside `s + s` and that both strings have the same length.

## Approach
1. **Immediate equality** – If `s` and `goal` are already identical, return `true`.  
2. **Build doubled string** – Create `dummy = s + s`.  
3. **Containment check** – Use `dummy.contains(goal)` to test if `goal` appears as a substring.  
4. **Length guard** – Ensure `goal.length() == s.length()` to avoid false positives when `goal` is shorter or longer.  
5. **Return result** – The conjunction of the containment test and length equality yields the answer.

This method leverages Java’s efficient `String.contains` (which internally uses `indexOf`) to perform the substring search.

## Complexity
- **Time:** O(n) – scanning the doubled string of length 2n for a substring of length n.  
- **Space:** O(n) – storing the doubled string `dummy`.

## Solution (java)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        String dummy = s + s;
        return dummy.contains(goal) && goal.length() == s.length();
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.5 MB

<sub>Synced by AILeetHub on 2026-05-04.</sub>
