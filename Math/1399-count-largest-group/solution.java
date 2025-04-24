class Solution {
    private int findDigitSum(int num){
        int result = 0;
        while(num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }
    public int countLargestGroup(int n) {
        int [] groups = new int [37];
        int maxGroup = 0;
        for (int i = 1; i <= n; i++){
            int digitsum = findDigitSum(i);
            groups[digitsum]++;
            maxGroup = Math.max(maxGroup, groups[digitsum]);
        }
        int count = 0;
        for (int size : groups){
            if (size == maxGroup){
                count++;
            }
        }
        return count;
    }
}
// class Solution {
//     private int findDigitSum(int num){
//         int result = 0;
//         while(num > 0){
//             result += num % 10;
//             num /= 10;
//         }
//         return result;
//     }
//     public int countLargestGroup(int n) {
//         int maxSize = 0;
//         HashMap <Integer, Integer> Map = new HashMap<Integer, Integer>();
//         for (int i = 1; i <= n; i++){
//             int digitsum = findDigitSum(i);
//             Map.put(digitsum, Map.getOrDefault(digitsum, 0) + 1);
//             maxSize = Math.max(maxSize, Map.get(digitsum));   

//         }
//         int count = 0;
//         for (int size : Map.values()){
//             if (size == maxSize) {count ++;}
//         }
//         return count;
//     }
// }