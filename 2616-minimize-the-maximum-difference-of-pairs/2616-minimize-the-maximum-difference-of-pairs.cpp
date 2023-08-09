class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        sort(nums.begin(), nums.end());
        int left = 0, right = 1e9;
        
        int result = 0;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(helper(mid, nums, p)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return result;
    }
    
private:
    bool helper(int mid, vector<int>& nums, int p){
        int count = 0;
        
        for(int i=1;i<nums.size();i++){
            if(nums[i] - nums[i-1] <= mid){
                count++;
                i++; // we need to directly go from i to i+2, so this line will increment i by 1 and for loop one more time
            }
        }
        
        return count >= p;
    }
};