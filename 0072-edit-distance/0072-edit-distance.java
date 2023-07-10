class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int [][] memo = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return calculateMinOperations(m-1, n-1, word1, word2, memo);
    }
    
    private int calculateMinOperations(int index1, int index2, String word1, String word2, int [][] memo){
        if(index1 < 0 && index2 >=0){
            return index2+1; // We need to add remaining word2 chars
        }
        
        if(index2 < 0 && index1 >=0){
            return index1+1; // We need to delete rest of chars of word1
        }
        
        if(index1 < 0 && index2 < 0){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return 0 + calculateMinOperations(index1-1, index2-1, word1, word2, memo);
        }
        else{
            // Every operation we perform on word1
            int addOperation = 1 + calculateMinOperations(index1, index2-1, word1, word2, memo);
            int deleteOperation = 1 + calculateMinOperations(index1-1, index2, word1, word2, memo);
            int updateOperation = 1 + calculateMinOperations(index1-1, index2-1, word1, word2, memo);
            
            return memo[index1][index2] = Math.min(addOperation, Math.min(deleteOperation, updateOperation));
        }
    }
}