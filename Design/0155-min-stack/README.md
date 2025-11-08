# 155. Min Stack

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/min-stack/)

`Stack` · `Design`

## Approach

Accepted medium solution in java.
Relevant topics: Stack, Design.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class MinStack {
    private Stack<Integer> mainStack ;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<Integer> ();
        minStack = new Stack<Integer> ();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();

    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

---

**Runtime** 5 ms · **Memory** 47 MB

<sub>Synced by AILeetHub on 2025-11-08.</sub>
