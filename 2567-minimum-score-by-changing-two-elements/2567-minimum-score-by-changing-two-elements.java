class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        
        /*
            What if we dont have any flexibility to change the value of atmost 2 elements of nums
            Then, score would be:
            nums = [1,4,7,8,5]
            Sort it: nums = [1,4,5,7,8]
            low score = 1 (|4-5|)
            high score = 7 (|1-8|)
            Overall score: low score + high score = 1 + 7 = 8
            
            But now we will consider the condition which allows to change the value of atmost 2 elements
            We can observe one thing here we can always make low score as zero, by making one value equal to other value
            
            score = 0 (low score) + min(nums[n-1] - nums[2], nums[n-2] - nums[1], nums[n-3]- nums[0]) 
        */
        
        Arrays.sort(nums);
        
        int score = 0 + Math.min(nums[n-1]-nums[2], Math.min(nums[n-2]-nums[1], nums[n-3] - nums[0]));
        
        return score;
    }
}