class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];

        for (int [] year: logs){
            population[year[0] - 1950]++;
            population[year[1] - 1950]--;
        }
        
        // Calculating max population
        int maxPop = 0, curPop = 0, curYear = 1950;

        for(int i = 0; i < 101; i++){
            curPop += population[i];

            if (curPop > maxPop) {
                maxPop = curPop;
                curYear = 1950 + i;
            }
        }
        return curYear;

    }
}