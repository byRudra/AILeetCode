# 150. Evaluate Reverse Polish Notation

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

`Array` · `Math` · `Stack`

## Intuition  
Reverse‑Polish Notation (RPN) writes operators after their operands, so an expression can be evaluated in a single left‑to‑right pass. Whenever an operator appears, the two most recent values are the operands for that operator. A stack naturally stores these intermediate results, allowing constant‑time access to the needed operands.

## Approach  
Iterate over each token in the input array.  
- If the token is an operator (`+`, `-`, `*`, `/`), pop the top two integers from the stack (`b` then `a`), compute `a op b` using integer division that truncates toward zero, and push the result back.  
- If the token is a number, parse it to an integer and push it onto the stack.  
After processing all tokens, the stack contains a single element: the value of the entire expression, which is returned.

The helper methods `isOpp` and `applyOpp` encapsulate operator detection and application, keeping the main loop concise.

## Complexity  
- **Time:** O(n) – each token is examined once and stack operations are O(1).  
- **Space:** O(n) – the stack may hold up to n/2 operands in the worst case (e.g., all numbers before operators).

## Solution (java)

```java
class Solution {
    private static boolean isOpp(String a){
        return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/");
    }

    private static int applyOpp(int a, int b, String op){
        switch(op){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(isOpp(token)){
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOpp(a,b,token);
                stack.push(result);
            }
            else {stack.push(Integer.parseInt(token));}
        }

        return stack.pop();
    }
}
```

---

**Runtime** 6 ms · **Memory** 45.2 MB

<sub>Synced by AILeetHub on 2025-11-08.</sub>
