class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder number = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int temp = columnNumber % 26;
            number.insert(0, (char) ('A' + temp));
            columnNumber = columnNumber / 26;
        }
        return number.toString();
    }
}