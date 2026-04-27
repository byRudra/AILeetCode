class Solution {
    public int titleToNumber(String columnTitle) {
       int result = 0;

       for(char ch : columnTitle.toCharArray()){
        int current = ch - 'A' + 1;
        result = result*26 + current;
       }
       return result; 
    }
}