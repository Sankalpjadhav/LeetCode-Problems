class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        map = {}

        for i in range(n):
            num = target - nums[i]
            if num in map:
                return [map[num], i]
            else:
                map[nums[i]] = i
        
        return [-1, -1]





'''
Brute force: 

def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        for i in range(n):
            for j in range(i+1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
        
        return [-1, -1]
'''
