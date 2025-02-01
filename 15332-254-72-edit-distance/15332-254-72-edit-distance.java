class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        
        for(int j=0;j<=n;j++){
            dp[0][j] = j;
        }

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(word1.charAt(index1-1) == word2.charAt(index2-1)){
                    dp[index1][index2] = 0 + dp[index1-1][index2-1]; 
                }
                else{
                    int insert = 1 + dp[index1][index2-1]; 

                    int remove = 1 + dp[index1-1][index2]; 

                    int update = 1 + dp[index1-1][index2-1];

                    dp[index1][index2] = Math.min(update, Math.min(insert, remove));
                }

                
            }
        }
        return dp[m][n];
    }
}

/*
MEMOIZATION:

public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] memo = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }
        return editDistance(m, n, word1, word2, memo);
    }

    private int editDistance(int index1, int index2, String word1, String word2, int [][] memo){
        if(index1 == 0 && index2 == 0){
            return 0;
        }

        if(index2 == 0){
            return index1;
        }

        if(index1 == 0){
            return index2;
        }

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }


        if(word1.charAt(index1-1) == word2.charAt(index2-1)){
            return memo[index1][index2] = 0 + editDistance(index1-1, index2-1, word1, word2, memo); // If the chars are matching then there is no need to perform any operations
        }

        // Assume we are inserting char at word1 same as what it was present at index2. So, we will just move index2 and not move index1 
        // because that char can match with current char of word2
        int insert = 1 + editDistance(index1, index2-1, word1, word2, memo); 
        // We will delete the char of word1 which is not matching
        int remove = 1 + editDistance(index1-1, index2, word1, word2, memo); 
        // 
        int update = 1 + editDistance(index1-1, index2-1, word1, word2, memo);

        return memo[index1][index2] = Math.min(update, Math.min(insert, remove));
    }

RECURSION: Exponential

public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        return editDistance(m, n, word1, word2);
    }

    private int editDistance(int index1, int index2, String word1, String word2){
        if(index1 == 0 && index2 == 0){
            return 0;
        }

        if(index2 == 0){
            return index1;
        }

        if(index1 == 0){
            return index2;
        }


        if(word1.charAt(index1-1) == word2.charAt(index2-1)){
            return 0 + editDistance(index1-1, index2-1, word1, word2); // If the chars are matching then there is no need to perform any operations
        }

        // Assume we are inserting char at word1 same as what it was present at index2. So, we will just move index2 and not move index1 
        // because that char can match with current char of word2
        int insert = 1 + editDistance(index1, index2-1, word1, word2); 
        // We will delete the char of word1 which is not matching
        int remove = 1 + editDistance(index1-1, index2, word1, word2); 
        // 
        int update = 1 + editDistance(index1-1, index2-1, word1, word2);

        return Math.min(update, Math.min(insert, remove));
    }
*/