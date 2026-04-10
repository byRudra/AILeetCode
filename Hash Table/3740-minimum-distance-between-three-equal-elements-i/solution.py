class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        pos = defaultdict(list)
        ans = float("inf")

        for i, num in enumerate(nums):
            pos[num].append(i)

        for arr in pos.values():
            if len(arr) >= 3:
                for j in range(len(arr) - 2):
                    ans = min(ans, 2 * (arr[j + 2] - arr[j]))

        return -1 if ans == float('inf') else ans 
