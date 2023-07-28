class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int firstPlayerScore = calculateScore(0, n-1, nums);
        int totalScore = 0;
        for(int score: nums){
            totalScore += score;
        }
        return firstPlayerScore >= totalScore - firstPlayerScore; 
    }
    
    private int calculateScore(int i, int j, int [] nums){
        if(i > j){
            return 0;
        }
        
        if(i == j){
            // if there is only 1 element then obviously player1 will prefer in order to win
            return nums[i];
        }
        
        int currentScore = Math.max(
                        nums[i] + Math.min(calculateScore(i+2, j, nums), calculateScore(i+1, j-1, nums)),
                        nums[j] + Math.min(calculateScore(i+1, j-1, nums), calculateScore(i, j-2, nums))
        );
        
        return currentScore;
    }
}

/*
                First player has option to choose i or j
                If he chooses i then 2nd player to choose in (i+1, j)
                    - if 2nd player chooses i+1, then player 1 will next choose from (i+2,j)
                    - if 2nd player chooses j, then player 1 will next choose from (i+1,j-1)
                If he chooses j then 2nd player to choose in (i, j-1)
                    - if 2nd player chooses i, then player 1 will next choose from (i+1,j-1)
                    - if 2nd player chooses j-1, then player 1 will next choose from (i,j-2)
                    
                We know that player 2 would have played wisely and player 1 will get the the minimum in the next move.
                We choose the best(Max) of the above 2 scenarios
*/