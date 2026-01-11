// class Solution {
//     public boolean canPlaceFlowers(int[] flowerbed, int n) {
//         if (flowerbed.length == 1) {
//             if (n == 0)
//                 return true;
//             return flowerbed[0] == 0;
//         }

//         for (int i = 0; i < flowerbed.length; i++) {
//             if (i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0) {
//                 flowerbed[0] = 1;
//                 n--;
//             } else if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0
//                     && flowerbed[flowerbed.length - 2] == 0) {
//                 flowerbed[flowerbed.length - 1] = 1;
//                 n--;
//             } else {
//                 if (i > 0 && i < flowerbed.length - 1) {
//                     if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
//                         flowerbed[i] = 1;
//                         n--;
//                     }
//                 }
//             }
//         }
//         return n <= 0;
//     }
// }

class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        for(int i = 0; i < f.length; i+=2){
            if(f[i] == 0){
                if(i == f.length - 1 || f[i] == f[i+1]){
                    n--;
                }
                else i++;
            }
        }
        return n <= 0;
    }
}