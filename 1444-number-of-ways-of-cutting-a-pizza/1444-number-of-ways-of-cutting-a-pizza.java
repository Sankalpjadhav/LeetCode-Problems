class Solution {
    private final int MOD = (int) 1e9 + 7;
    
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        
        int [][] prefixSum = new int[m+1][n+1]; // It will denote how many apples are there from (i,j) to (m-1, n-1).
        
        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                prefixSum[row][col] = prefixSum[row+1][col] + prefixSum[row][col+1] - prefixSum[row+1][col+1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }
        
        int [][][] memo = new int[m][n][k];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return helper(0, 0, m, n, k-1, prefixSum, pizza, memo);
    }
    
    private int helper(int row, int col, int m, int n, int cuts, int [][] prefixSum, String [] pizza, int [][][] memo){
        if(prefixSum[row][col] == 0){
            // If the remaining pizza has no apples left then there is no way we can cut further
            return 0;
        }
        
        if(cuts == 0){
            return 1;
        }
        
        if(memo[row][col][cuts] != -1){
            return memo[row][col][cuts];
        }
        
        int totalWaysToCut = 0;
        
        // Horizontal cut
        for(int hRow=row+1;hRow<m;hRow++){
            if(prefixSum[row][col] - prefixSum[hRow][col] >= 1){
                totalWaysToCut = (totalWaysToCut + helper(hRow, col, m, n, cuts-1, prefixSum, pizza, memo)) % MOD;
            }
        }
        // Vertical cut
        for(int vCol=col+1;vCol<n;vCol++){
            if(prefixSum[row][col] - prefixSum[row][vCol] >= 1){
                totalWaysToCut = (totalWaysToCut + helper(row, vCol, m, n, cuts-1, prefixSum, pizza, memo)) % MOD;
            }
        }
        
        return memo[row][col][cuts] = totalWaysToCut;
    }
}

// Was not able to solve in first attempt: https://www.youtube.com/watch?v=4Jiha4IF9Mk

/*
RECURSION: TLE 

private final int MOD = (int) 1e9 + 7;
    
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        
        int [][] prefixSum = new int[m+1][n+1]; // It will denote how many apples are there from (i,j) to (m-1, n-1).
        
        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                prefixSum[row][col] = prefixSum[row+1][col] + prefixSum[row][col+1] - prefixSum[row+1][col+1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }
        
        return helper(0, 0, m, n, k-1, prefixSum, pizza);
    }
    
    private int helper(int row, int col, int m, int n, int cuts, int [][] prefixSum, String [] pizza){
        if(prefixSum[row][col] == 0){
            // If the remaining pizza has no apples left then there is no way we can cut further
            return 0;
        }
        
        if(cuts == 0){
            return 1;
        }
        
        int totalWaysToCut = 0;
        
        // Horizontal cut
        for(int hRow=row+1;hRow<m;hRow++){
            if(prefixSum[row][col] - prefixSum[hRow][col] >= 1){
                totalWaysToCut = (totalWaysToCut + helper(hRow, col, m, n, cuts-1, prefixSum, pizza)) % MOD;
            }
        }
        // Vertical cut
        for(int vCol=col+1;vCol<n;vCol++){
            if(prefixSum[row][col] - prefixSum[row][vCol] >= 1){
                totalWaysToCut = (totalWaysToCut + helper(row, vCol, m, n, cuts-1, prefixSum, pizza)) % MOD;
            }
        }
        
        return totalWaysToCut;
    }

*/