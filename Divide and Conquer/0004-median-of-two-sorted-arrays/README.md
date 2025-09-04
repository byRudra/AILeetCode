# 4. Median of Two Sorted Arrays

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/)

`Array` · `Binary Search` · `Divide and Conquer`

## Intuition  
The two input arrays are already sorted. By merging them into a single sorted array we obtain the exact ordering of all elements. Once the merged array is available, the median is simply the middle element (or the average of the two middle elements) depending on the total length. This straightforward approach guarantees correctness while keeping the implementation simple.

## Approach  
1. **Merge**: Use two indices (`i` for `nums1`, `j` for `nums2`) and a third index (`k`) for the result array `finalArray`.  
   - While both indices are within bounds, compare `nums1[i]` and `nums2[j]`.  
   - Append the smaller value to `finalArray` and advance the corresponding index.  
   - After one array is exhausted, copy the remaining elements of the other array into `finalArray`.  
2. **Median extraction**:  
   - Compute `total = size1 + size2`.  
   - If `total` is odd, return the element at `total/2`.  
   - If even, return the average of the elements at positions `total/2` and `total/2 - 1`.  

The algorithm directly follows the merge step of merge sort and then applies the standard median formula.

## Complexity  
- **Time:** O(m + n) – each element of the two arrays is processed once during the merge.  
- **Space:** O(m + n) – the merged array stores all elements from both inputs.

## Solution (java)

```java
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
```

---

**Runtime** 1 ms · **Memory** 46.1 MB

<sub>Synced by AILeetHub on 2025-09-04.</sub>
