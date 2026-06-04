class Solution {

    private int currentWaviness(long num){
        String numString = String.valueOf(num);
        if (numString.length() < 3) return 0;
        int count = 0;
        for(int i = 1; i < numString.length() - 1; i++){
            char left = numString.charAt(i - 1);
            char mid = numString.charAt(i);
            char right = numString.charAt(i + 1);
            if((left > mid && mid < right) || (mid > left && mid > right)) count++;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        long ans = 0;
        for(long num = num1; num <= num2; num++){
            ans += currentWaviness(num);
        }
        return (int) ans;
    }
}