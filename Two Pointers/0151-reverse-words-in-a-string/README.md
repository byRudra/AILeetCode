# 151. Reverse Words in a String

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-words-in-a-string/)

`Two Pointers` · `String`

## Approach

Accepted medium solution in java.
Relevant topics: Two Pointers, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder reversedString = new StringBuilder("");

        s = s.trim();

        int index = s.length() - 1;

        while(index >= 0){
            int length = 0;
            while(index >= 0 && s.charAt(index) != ' '){
                index--;
                length++;
            }
            reversedString.append(s.substring(index+1,index+1+length));
            reversedString.append(" ");
            if(index < 0)break;
            while(index >= 0 && s.charAt(index) == ' '){
                index--;
            }
        }
        return reversedString.toString().trim();
    }
}
```

---

**Runtime** 4 ms · **Memory** 44.3 MB

<sub>Synced by AILeetHub on 2026-01-07.</sub>
