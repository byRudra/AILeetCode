// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//         for(String x : arr){
//             map.put(x, map.getOrDefault(x, 0) + 1);
//         }
//         for(String x : map.keySet()){
//             if(map.get(x) == 1){
//                 k--;
//             }
//             if(k == 0){
//                 return x;
//             }
//         }
//         return "";   
//     }
// }

class Solution {
    public String kthDistinct(String[] arr, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // 1. Count frequency
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // 2. Traverse original array to preserve order
        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;

                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }
}