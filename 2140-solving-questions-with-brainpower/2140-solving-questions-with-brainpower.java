class Solution {
    public long mostPoints(int[][] questions) {
        int numberOfQuestions = questions.length;
        long [] memo = new long[numberOfQuestions];
        Arrays.fill(memo, -1);
        return helper(0, memo, numberOfQuestions, questions);
    }
    
    private long helper(int index, long [] memo, int numberOfQuestions, int [][] questions){
        if(index >= numberOfQuestions){
            return 0;    
        }
        
        if(index == numberOfQuestions - 1){
            return questions[index][0];
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        // Solve the current question
        long solvedQuestionPoints = questions[index][0] + helper(index + questions[index][1] + 1, memo, numberOfQuestions, questions);
        
        // Skip the current question
        long unsolvedQuestionPoints = 0 + helper(index+1, memo, numberOfQuestions, questions);
        
        return memo[index] = Math.max(unsolvedQuestionPoints, solvedQuestionPoints);
    }
}