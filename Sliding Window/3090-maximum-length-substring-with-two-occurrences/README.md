# 3090. Maximum Length Substring With Two Occurrences

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)

`Hash Table` · `String` · `Sliding Window`

## Intuition
We need the longest contiguous block where no letter appears more than twice.  
If we keep a window that always satisfies this rule, extending the right end may break it.  
When a character’s count exceeds two, the only way to restore validity is to move the left edge rightward, removing characters from the window until the offending count drops back to two.

## Approach
1. Use a hash map to store the current count of each character inside the window.  
2. Iterate `right` from 0 to `s.length‑1`.  
   * Add `s[right]` to the map.  
   * While the count of `s[right]` is greater than 2, shrink the window from the left: decrement the count of `s[left]` and increment `left`.  
3. After the window is valid, update `longest` with `right - left + 1`.  
4. Return `longest` after the loop.

The map always contains only characters present in the current window, and the left pointer never moves leftward, ensuring each character is processed a constant number of times.

## Complexity
- **Time:** O(n) – each index is added to and removed from the window at most once.  
- **Space:** O(1) – the map holds at most 26 entries for lowercase letters.

## Solution (java)

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);
            while (map.get(current) > 2) {
                char remove = s.charAt(left++);
                map.put(remove, map.get(remove) - 1);
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
```

---

**Runtime** 3 ms · **Memory** 43.7 MB

<sub>Synced by AILeetHub on 2026-08-14.</sub>
