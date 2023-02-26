class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        
        int n1 = word1.length()-1;
        int n2 = word2.length()-1;
        
        int [][] memo = new int[n1+1][n2+1];
        
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(n1, n2, word1, word2, memo);
    }
    
    private int helper(int index1, int index2, String word1, String word2, int [][] memo){
        if(index1 == -1 && index2 == -1){
            return 0;
        }
        
        if(index1 < 0){
            return index2 + 1;
        }
        
        if(index2 < 0){
            return index1 + 1;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return memo[index1][index2] = 0 + helper(index1-1, index2-1, word1, word2, memo);
        }
        else{
            // Inserting character
            int insertOperation = 1 + helper(index1, index2-1, word1, word2, memo);
            
            // Replace character
            int replaceOperation = 1 + helper(index1-1, index2-1, word1, word2, memo);
            
            // Delete character
            int deleteOperation = 1 + helper(index1-1, index2, word1, word2, memo);
            
            return memo[index1][index2] = Math.min(insertOperation, Math.min(replaceOperation, deleteOperation));
        }
    }
}


/*
Obviously Recursion solution will give TLE since it is exponential

    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        
        int n1 = word1.length()-1;
        int n2 = word2.length()-1;
        
        return helper(n1, n2, word1, word2);
    }
    
    private int helper(int index1, int index2, String word1, String word2){
        if(index1 == -1 && index2 == -1){
            return 0;
        }
        
        if(index1 < 0){
            return index2 + 1;
        }
        
        if(index2 < 0){
            return index1 + 1;
        }
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return helper(index1-1, index2-1, word1, word2);
        }
        else{
            // Inserting character
            int insertOperation = 1 + helper(index1, index2-1, word1, word2);
            
            // Replace character
            int replaceOperation = 1 + helper(index1-1, index2-1, word1, word2);
            
            // Delete character
            int deleteOperation = 1 + helper(index1-1, index2, word1, word2);
            
            return Math.min(insertOperation, Math.min(replaceOperation, deleteOperation));
        }
    }

*/