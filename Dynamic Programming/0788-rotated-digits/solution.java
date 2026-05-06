class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 0; i <= n; i++){
            if(isGood(i)) count++;
        }
        return count;
    }
    private boolean isGood(int num){
        boolean changed = false;
        while(num > 0){
            int digit = num % 10;
            if (digit == 3 || digit == 7 || digit == 4){
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) changed = true;
            num /= 10;
        }
        return changed;
    }
}