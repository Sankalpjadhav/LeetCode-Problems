class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        res = []
        n = len(nums)

        for i in range(0, n-1):
            if nums[i] == nums[i+1]:
                nums[i] *= 2
                nums[i+1] = 0
        
        for i in range(0, n):
            if nums[i] > 0:
                res.append(nums[i])

        # Fill the rest of the list with zeros
        res.extend([0] * (n - len(res)))
        
        return res

        