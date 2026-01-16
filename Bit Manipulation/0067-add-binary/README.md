# 67. Add Binary

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/add-binary/)

`Math` · `String` · `Bit Manipulation` · `Simulation`

## Intuition
Adding two binary numbers is analogous to decimal addition: start from the least‑significant bit, sum the bits together with any carry, and propagate the carry to the next position. Because the input strings are given most‑significant bit first, we process them from the end.

## Approach
1. Convert each string to a character array for O(1) index access.  
2. Initialize indices at the last positions of both arrays, a `carry` of 0, and a `StringBuilder` to collect result digits in reverse order.  
3. While any index is still valid or a carry remains, read the current bits (treat missing bits as 0), compute `sum = aBit + bBit + carry`.  
4. The new digit is `sum % 2`; update `carry = sum / 2`. Append the digit (as a character) to the builder.  
5. After the loop, reverse the builder to obtain the final binary string.

## Complexity
- **Time:** O(n + m) – each bit of both inputs is examined once.  
- **Space:** O(n + m) – the result string stores up to one more bit than the longer input.

## Solution (java)

```java
class Solution {
    public String addBinary(String a, String b) {
        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = charArrA.length - 1, j = charArrB.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int aNum = i >= 0 ? charArrA[i] - '0' : 0;
            int bNum = j >= 0 ? charArrB[j] - '0' : 0;

            int sum = aNum + bNum + carry;
            int digit = sum % 2;
            carry = sum / 2;
            i--;
            j--;

            sb.append((char)(digit + '0'));
        }

        return sb.reverse().toString();
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.8 MB

<sub>Synced by AILeetHub on 2026-01-16.</sub>
