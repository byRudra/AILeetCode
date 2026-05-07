# 496. Next Greater Element I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/next-greater-element-i/)

`Array` · `Hash Table` · `Stack` · `Monotonic Stack`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table, Stack, Monotonic Stack.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]) 
                nextGreaterMap.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            nextGreaterMap.put(stack.pop(), -1);
        }
        int result[] = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }
}

```

---

**Runtime** 3 ms · **Memory** 45.1 MB

<sub>Synced by AILeetHub on 2026-05-07.</sub>
