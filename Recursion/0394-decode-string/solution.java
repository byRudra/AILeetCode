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