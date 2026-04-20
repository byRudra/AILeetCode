class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        maxDistance = 0
        i = 0
        j = 0
        while(i <= j and i < len(nums1) and j < len(nums2)):
            if nums1[i] <= nums2[j]:
                maxDistance = max(maxDistance, j - i)
                j += 1
            else:
                j += 1
                i += 1

        return maxDistance