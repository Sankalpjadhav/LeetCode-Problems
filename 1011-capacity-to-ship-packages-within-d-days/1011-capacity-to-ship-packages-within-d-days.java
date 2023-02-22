class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = weights[0];
        int high = 0;
        
        for(int weight: weights){
            high += weight;
            low = Math.min(low, weight);
        }
        
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isItPossibleToAllocate(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isItPossibleToAllocate(int [] weights, int barrier, int days){
        int numberOfDays = 1;
        int weight = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i] > barrier){
                return false;
            }
            
            if(weight + weights[i] > barrier){
                weight = weights[i];
                numberOfDays++;
            }
            else{
                weight += weights[i];
            }
            
        }
        
        if(numberOfDays > days){
            return false;
        }
        
        return true;
    }
}