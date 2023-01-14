class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = (int)1e5;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(distribute(quantities, mid) <= n){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int distribute(int [] quantities, int mid){
        int max = 0;
        
        for(int i=0; i<quantities.length; i++){
            max += (int)Math.ceil((double)quantities[i]/mid);
        }
        
        return max;
    }
}