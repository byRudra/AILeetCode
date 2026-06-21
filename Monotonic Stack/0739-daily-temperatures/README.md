# 739. Daily Temperatures

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/daily-temperatures/)

`Array` · `Stack` · `Monotonic Stack`

## Intuition  
For each day we need the next warmer day.  
If we scan from left to right, a warmer day for a previous index can only be found later.  
Thus, while iterating we can keep a stack of indices whose temperatures are waiting for a warmer future day.  
When a new temperature arrives, it can resolve all earlier days that are cooler than it.

## Approach  
1. Create an array `result` of the same length as `temperatures`.  
2. Iterate over the array with index `i`.  
3. While the stack is non‑empty and `temperatures[i]` is higher than the temperature at the index on the stack’s top, pop that index `prevDay`.  
   * The current day `i` is the first warmer day for `prevDay`, so set `result[prevDay] = i - prevDay`.  
4. Push the current index `i` onto the stack.  
5. After the loop, any indices left in the stack have no warmer future day, so their `result` entries remain `0`.  
6. Return `result`.

The stack always contains indices in decreasing temperature order, guaranteeing each index is pushed and popped at most once.

## Complexity  
- **Time:** O(n) – each temperature is processed once and each index is pushed and popped at most once.  
- **Space:** O(n) – the stack may hold up to n indices in the worst case (e.g., strictly decreasing temperatures).

## Solution (java)

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevDay = stack.pop();

                result[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return result;
    }
}
```

---

**Runtime** 61 ms · **Memory** 107.7 MB

<sub>Synced by AILeetHub on 2026-06-21.</sub>
