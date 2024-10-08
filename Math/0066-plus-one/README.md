# 66. Plus One

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/plus-one/)

`Array` · `Math`

## Intuition  
The number is stored most‑significant digit first, so the least significant digit is at the end of the vector. Adding one may create a carry that propagates leftward. If a digit is less than 9, the carry stops there; otherwise the digit becomes 0 and the carry continues. When every digit is 9, the carry extends beyond the most significant digit, requiring a new leading 1.

## Approach  
Traverse the vector from the last index toward the first.  
* If the current digit is < 9, simply increment it and return the vector.  
* If the digit equals 9, set it to 0 and continue the loop to propagate the carry.  
If the loop finishes without returning, all digits were 9; insert a 1 at the beginning of the vector and return.  
The algorithm modifies the input in place, only adding one element when necessary.

## Complexity  
- **Time:** O(n) – each element is inspected at most once.  
- **Space:** O(1) – only constant‑size variables are used; the vector is modified in place except for the optional single insertion.

## Solution (cpp)

```cpp
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size() - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits.insert(digits.begin(), 1);
        return digits;
    }
};
```

---

**Runtime** 0 ms · **Memory** 10.6 MB

<sub>Synced by AILeetHub on 2024-10-08.</sub>
