# 788. Rotated Digits

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotated-digits/)

`Math` · `Dynamic Programming`

## Intuition  
A number is “good” only when every digit can be rotated (0,1,8 stay the same; 2↔5 and 6↔9 change) and at least one digit actually changes. Digits 3,4,7 cannot appear because they become invalid after rotation. Thus a number is good iff it contains no 3,4,7 and contains at least one of 2,5,6,9.

## Approach  
The solution simply enumerates every integer from 0 up to `n`. For each candidate, it inspects its decimal digits one by one.  
* If a digit is 3, 4, or 7, the number is immediately rejected.  
* If a digit is 2, 5, 6, or 9, a flag `changed` is set to true, indicating that the rotated number will differ from the original.  
After all digits are processed, the number is counted as good only when `changed` is true. The loop runs from 0 to `n` inclusive, so the count includes all numbers in the required range.

## Complexity  
- **Time:** O(n log n) – each of the `n+1` numbers is examined digit‑by‑digit, and a number with `d` digits takes O(d) time.  
- **Space:** O(1) – only a few integer variables are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 0; i <= n; i++){
            if(isGood(i)) count++;
        }
        return count;
    }
    private boolean isGood(int num){
        boolean changed = false;
        while(num > 0){
            int digit = num % 10;
            if (digit == 3 || digit == 7 || digit == 4){
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) changed = true;
            num /= 10;
        }
        return changed;
    }
}
```

---

**Runtime** 4 ms · **Memory** 42.2 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
