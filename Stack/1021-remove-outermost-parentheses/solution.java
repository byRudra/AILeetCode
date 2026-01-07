class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder finalString = new StringBuilder("");
        int depth = 0;
        for (char current : s.toCharArray()) {
            if (current == '(') {
                if (depth > 0)
                    finalString.append(current);
                depth++;
            } else {
                depth--;
                if (depth > 0)
                    finalString.append(current);
            }
        }

        return finalString.toString();
    }
}