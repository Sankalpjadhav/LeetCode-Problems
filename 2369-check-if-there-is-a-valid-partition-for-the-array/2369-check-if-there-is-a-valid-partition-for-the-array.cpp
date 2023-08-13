class Solution {
public:
    bool validPartition(vector<int>& nums) {
        int n = nums.size();
        vector<int> memo(n, -1);
        return helper(0, n, nums, memo);
    }
    
private:
    bool helper(int index, int n, vector<int>& nums, vector<int>& memo){
        if(index == n){
            return true;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        if(index+1 < n && nums[index] == nums[index+1]){
            if(helper(index+2, n, nums, memo)){
                return memo[index] = true;
            }
            
            if(index+2 < n && nums[index] == nums[index+2]){
                if(helper(index+3, n, nums, memo)){
                    return memo[index] = true;
                }
            }
        }
        
        if(index+2 < n && nums[index] == nums[index+1]-1 && nums[index] == nums[index+2]-2){
            if(helper(index+3, n, nums, memo)){
                return memo[index] = true;
            }
        }
        
        return memo[index] = false;
    }
};