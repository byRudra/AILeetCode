class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int result[] = new int[spells.length];
        int st = 0;
        for(int spell: spells){
            int start = 0;
            int end = potions.length;
            while(start <end){
                int mid = start + (end - start) / 2;
                if((long)potions[mid] * spell >= success){
                    end=mid;
                }
                else
                    start = mid + 1;
            }
            result[st++] = potions.length - start;
        }
        return result;
    }
}