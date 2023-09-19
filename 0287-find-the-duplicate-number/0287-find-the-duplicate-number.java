class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow]; // Moving one point at a time
            fast = nums[nums[fast]]; // Moving two point at a time
        }while(slow!=fast);
        // Now we are done with linked list slow and fast ptr approach
        fast = nums[0]; // Move fast back to start
        while(fast!=slow){
            slow = nums[slow];
            fast= nums[fast];
        }
        return slow; // or return fast;
    }
}