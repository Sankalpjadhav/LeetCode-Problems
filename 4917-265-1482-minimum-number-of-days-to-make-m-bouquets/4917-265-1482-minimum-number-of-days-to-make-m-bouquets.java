class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        if(m*k > n) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int res = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canAdjacentFlowersFormBouquets(mid, bloomDay, m, k, n)){
                high = mid - 1;
                res = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return res;
    }

    private boolean canAdjacentFlowersFormBouquets(int days, int [] bloomDay, int numberOfBouquets, int adjacentFlowers, int n){
        int currentDay = 0;
        int bouquetsFormed = 0;

        for(int i=0;i<n;i++){
            if(bloomDay[i] <= days){
                currentDay++;
            }
            else{
                currentDay = 0;
            }

            if(currentDay == adjacentFlowers){
                bouquetsFormed++;
                currentDay = 0;
            }
        }

        return bouquetsFormed>=numberOfBouquets;
    }
}