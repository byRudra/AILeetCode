// class Solution {
//     public int largestAltitude(int[] gain) {
//         int realArray[] = new int[gain.length + 1];
//         realArray[0] = 0;
//         for(int i = 0; i < gain.length; i++) {
//             realArray[i + 1] = realArray[i] + gain[i];
//         }
//         int highest = Integer.MIN_VALUE;
//         for(int num : realArray){
//             highest = Math.max(num, highest);
//         }
//         return highest;
//     }
// }

class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int currentAlti = 0;
        for(int num : gain){
            currentAlti += num;
            highest = Math.max(currentAlti, highest);
        }
        return highest;
    }
}