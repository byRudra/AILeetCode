class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long place = 1;
        long sum = 0;
        while(n != 0){
            long digit = n % 10;
            if(digit != 0){
                x += digit * place;
                place *= 10;
                sum += digit;
            }
            n /= 10;
        }
        return x * sum;
    }
}