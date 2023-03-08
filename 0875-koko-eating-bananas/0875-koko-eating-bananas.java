class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = maxPile(piles);
        
        while(low < high){
            int k = low + (high - low)/2;
            if(canEatAll(piles, k, h)){
                high = k;
            }
            else{
                low = k + 1;
            }
        }
        
        return low;
    }
    
    private boolean canEatAll(int [] piles, int k, int h){
        int countHour = 0;
        for(int pile: piles){
            countHour += pile / k;
            if(pile % k != 0){
                countHour++;
            }
        }
        
        return countHour <= h;
    }
    
    private int maxPile(int [] piles){
        int max = 1;
        for(int pile: piles){
            max = Math.max(pile, max);
        }
        
        return max;
    }
}