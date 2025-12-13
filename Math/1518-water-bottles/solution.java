class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int init = numBottles;
        int quot, remainder;
        while(numBottles > numExchange - 1){
            quot = numBottles / numExchange;
            remainder = numBottles % numExchange;
            numBottles = quot + remainder;
            init += quot;
        }
        return init;
    }
}