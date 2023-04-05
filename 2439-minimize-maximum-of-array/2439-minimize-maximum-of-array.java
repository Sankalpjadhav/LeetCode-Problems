class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = (int) 1e9;

        
        int ans = 0;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(possibleAns(mid, nums)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return ans; 
    }
    
    private boolean possibleAns(int mid, int [] nums){
        long debt = 0;
        for (int n : nums) {
            if (n <= mid) {
                debt += mid - n;
            } else {
                if (debt < n - mid)
                    return false;
                else
                    debt -= (n - mid);
            }
        }
        return true;
    }
}