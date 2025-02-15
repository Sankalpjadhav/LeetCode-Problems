class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        for(int i=0;i<n;i++){
            high = Math.max(high, piles[i]);
        }
        int res = -1;
        while(low <= high){
            int speedK = low + (high - low)/2;
            if(canEatBananas(piles, speedK, h)){
                res = speedK;
                high = speedK - 1;
            }
            else{
                low = speedK + 1;
            }
        }

        return res;
    }

    private boolean canEatBananas(int [] piles, int speedK, int h){
        int countHours = 0;
        
        for(int pile: piles){
            countHours += (pile + speedK - 1) / speedK;
            if (countHours > h) {  
                return false;
            }
        }
        
        return countHours <= h;
    }
}