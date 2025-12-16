# 58. Length of Last Word

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/length-of-last-word/)

`String`

## Intuition  
The last word is the contiguous block of non‑space characters that ends at the last non‑space position of the string.  
If we locate that last non‑space index, the preceding space (or the start of the string) marks the beginning of the last word.  
The distance between these two indices gives the word’s length.

## Approach  
1. **Skip trailing spaces** – start from the end of the string and move left until a non‑space character is found.  
2. **Find the word boundary** – keep moving left from that position until a space or the string start is reached.  
3. **Compute length** – the difference between the last non‑space index and the index just before the preceding space (or –1 if the word starts at index 0) yields the length of the last word.  
The algorithm uses two simple while loops that each scan a portion of the string at most once.

## Complexity  
- **Time:** O(n) – each character is examined at most twice (once while skipping spaces, once while finding the word start).  
- **Space:** O(1) – only a few integer variables are used, independent of input size.

## Solution (java)

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int ending = s.length() - 1;

        while(ending >= 0 && s.charAt(ending) == ' ') ending--;

        int starting = ending;

        while(starting >=0  && s.charAt(starting) != ' ') starting --;

        return ending - starting;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.9 MB

<sub>Synced by AILeetHub on 2025-12-16.</sub>
