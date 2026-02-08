# 503. Next Greater Element II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/next-greater-element-ii/)

`Array` · `Stack` · `Monotonic Stack`

## Intuition  
In a circular array each element’s next greater element is the first larger value encountered when moving forward, wrapping around to the start.  
A monotonic stack can keep track of indices whose next greater element is still unknown.  
When we encounter a value larger than the value at the stack’s top, that top’s next greater element is found.

## Approach  
1. Create an answer array initialized with –1.  
2. Use a stack to store indices of elements that have not yet found a greater value.  
3. Traverse the array twice (`i = 0 … 2*n-1`) to simulate circularity.  
   * `index = i % n` gives the current element’s position.  
   * While the stack isn’t empty and `nums[index]` is greater than `nums[stack.peek()]`, pop the stack and set the answer for that popped index to `nums[index]`.  
   * During the first pass (`i < n`) push the current index onto the stack; in the second pass we only pop, never push, to avoid duplicate work.  
4. After the loop, indices still on the stack have no greater element, so their answer remains –1.  
5. Return the answer array.

## Complexity  
- **Time:** O(n) – each index is pushed and popped at most once.  
- **Space:** O(n) – the stack holds at most n indices and the result array is of size n.

## Solution (java)

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                result[stack.pop()] = nums[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }
}

```

---

**Runtime** 10 ms · **Memory** 48.7 MB

<sub>Synced by AILeetHub on 2026-02-08.</sub>
