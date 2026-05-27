class Solution {
    public boolean detectCapitalUse(String word) {
        int countCapital = 0;
        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)) countCapital++;
        }
        return (countCapital == word.length()) || (countCapital == 1 && Character.isUpperCase(word.charAt(0))) || (countCapital == 0);
    }
}