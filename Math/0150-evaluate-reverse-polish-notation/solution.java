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