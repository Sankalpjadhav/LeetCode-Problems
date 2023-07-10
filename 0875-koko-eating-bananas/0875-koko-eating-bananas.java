class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = findMaxPile(piles);
        
        while(left < right){
            int k = left + (right - left)/2;
            if(canEatBananas(piles, k, h)){
                right = k;
            }
            else{
                left = k + 1;
            }
        }
        
        return right;
    }
    
    private boolean canEatBananas(int [] piles, int k, int h){
        int countHours = 0;
        
        for(int pile: piles){
            countHours += pile / k;
            if(pile % k != 0){
                countHours++;
            }
        }
        
        return countHours <= h;
    }
    
    private int findMaxPile(int [] piles){
        int max = 0;
        for(int pile: piles){
            max = Math.max(pile, max); 
        }
        
        return max;
    }
}