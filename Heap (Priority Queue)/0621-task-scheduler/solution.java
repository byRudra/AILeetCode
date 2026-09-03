class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freqs[] = new int[26];

        for(char task : tasks)
            freqs[task - 'A']++;
        int maxFreq = 0;
        for(int freq : freqs)
            maxFreq = Math.max(maxFreq, freq);
        int maxCount = 0;
        for(int freq : freqs){
            if(freq == maxFreq)
                maxCount++;
        }
        
        int frameSize = (maxFreq - 1) * (n + 1) + maxCount; 
        return Math.max(frameSize, tasks.length);
    }
}