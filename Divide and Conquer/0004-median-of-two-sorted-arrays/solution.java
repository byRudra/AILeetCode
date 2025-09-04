class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        int [] finalArray = new int [size1 + size2];
        int i = 0, j = 0, k = 0;

        // Merging Arrays Using Two pointer Approach
        while(i < size1 && j < size2){
            if(nums1[i] < nums2[j]){
                finalArray[k] = nums1[i];
                i++; 
            }
            else{
                finalArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i == size1){
            while(j < size2 ){
                finalArray[k] = nums2[j];
                k++;
                j++;
            }
        }
        else{
            while(i < size1 ){
                finalArray[k] = nums1[i];
                k++;
                i++;
            }
        }

        // finding median

        int isOdd = (size1 + size2) % 2;
        if(isOdd != 0){
            int mid = (size1 + size2) /  2 ;
            return finalArray[mid];
        }

        else{
            int mid1 = (size1 + size2) /  2 ;
            return (finalArray[mid1] +  finalArray[mid1 - 1]) / 2.0;
        }
            

    }
}