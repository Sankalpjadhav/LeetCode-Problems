class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int numberOfPiles = piles.size();
        Integer [][] memo = new Integer[numberOfPiles][k+1];
        return helper(numberOfPiles-1, k, piles, memo);
    }
    
    private int helper(int index, int k, List<List<Integer>> piles, Integer [][] memo){
        if(index < 0 || k == 0){
            return 0;
        }
        
        if(memo[index][k] != null){
            return memo[index][k];
        }
        
        int excludeCurrentPile = 0 + helper(index-1, k, piles, memo); // Skip the current pile
        
        int includeCurrentPile = 0;
        
        int minNumberOfElementsNeedToConsider = Math.min(k, piles.get(index).size());
        int sum = 0;
        for(int i=0;i<minNumberOfElementsNeedToConsider;i++){
            sum += piles.get(index).get(i); // Include element at 'i' of pile at 'index'
            includeCurrentPile = Math.max(includeCurrentPile, sum + helper(index-1, k-i-1, piles, memo));
        }
        
        return memo[index][k] = Math.max(includeCurrentPile, excludeCurrentPile);
    }
}

/*
Recursion : Obviously TLE

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int numberOfPiles = piles.size();
        
        return helper(numberOfPiles-1, k, piles);
    }
    
    private int helper(int index, int k, List<List<Integer>> piles){
        if(index < 0 || k == 0){
            return 0;
        }
        
        int excludeCurrentPile = 0 + helper(index-1, k, piles); // Skip the current pile
        
        int includeCurrentPile = 0;
        
        int minNumberOfElementsNeedToConsider = Math.min(k, piles.get(index).size());
        int sum = 0;
        for(int i=0;i<minNumberOfElementsNeedToConsider;i++){
            sum += piles.get(index).get(i); // Include element at 'i' of pile at 'index'
            includeCurrentPile = Math.max(includeCurrentPile, sum + helper(index-1, k-i-1, piles));
        }
        
        return Math.max(includeCurrentPile, excludeCurrentPile);
    }
*/