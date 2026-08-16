class Solution {
    public boolean stoneGameIX(int[] stones) {
        int keys[] = new int [3];
        for(int  i = 0; i < stones.length; i++)
            keys[stones[i] % 3]++;
        int c0 = keys[0];
        int c1 = keys[1];
        int c2 = keys[2];
        if(c0 % 2 == 0) return c1 > 0 && c2 > 0;

        return Math.abs(c1 - c2) > 2;

    }
}