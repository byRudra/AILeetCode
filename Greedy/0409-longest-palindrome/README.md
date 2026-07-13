# 409. Longest Palindrome

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-palindrome/)

`Hash Table` · `String` · `Greedy`

## Intuition  
A palindrome reads the same forward and backward, so every character used in its body must appear an even number of times. If a character occurs an odd number of times, we can use all but one of its occurrences in the symmetric halves and place the remaining single character in the center. Thus the longest palindrome length is the sum of the largest even counts for all characters, plus one more if any character has an odd count.

## Approach  
1. Count how many times each ASCII letter appears in the input string.  
2. For each frequency, add the largest even number not exceeding it (`count / 2 * 2`) to the answer.  
3. If the current answer is even and the current frequency is odd, increment the answer by one to place a single odd character in the middle.  
4. Return the accumulated answer.  
The algorithm uses a fixed‑size frequency array (256 entries) to handle both lowercase and uppercase letters.

## Complexity  
- **Time:** O(n) – each character is processed once for counting and once for summing.  
- **Space:** O(1) – the frequency array size is constant (256), independent of input length.

## Solution (java)

```java
class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int ans=0;
        for (int count : freq) {
            ans += count / 2 * 2;
            if (ans % 2 == 0 && count % 2 != 0)
                ans++;
        }
        return ans;
    }
}
```

---

**Runtime** 2 ms · **Memory** 43.2 MB

<sub>Synced by AILeetHub on 2026-07-13.</sub>
