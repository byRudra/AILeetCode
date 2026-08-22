# 394. Decode String

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/decode-string/)

`String` · `Stack` · `Recursion`

## Approach

Accepted medium solution in java.
Relevant topics: String, Stack, Recursion.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder substr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }
                stack.pop(); // poping / ]
                StringBuilder multipler = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    multipler.insert(0, stack.pop());
                }

                String decoded = substr.toString().repeat(Integer.parseInt(multipler.toString()));
                stack.push(decoded);
            }
        }
        return String.join("", stack);
    }
}
```

---

**Runtime** 1 ms · **Memory** 43 MB

<sub>Synced by AILeetHub on 2026-08-22.</sub>
