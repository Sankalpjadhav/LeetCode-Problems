class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        
        vector<vector<int>> memo (m, vector<int>(n, -1));
        
        return helper(0, 0, m, n, obstacleGrid, memo);
    }
    
private:
    int helper(int i, int j, int m, int n, vector<vector<int>>& obstacleGrid, vector<vector<int>>& memo){
        if(i == m-1 && j == n-1 && obstacleGrid[i][j] != 1){
            return 1;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int down = 0;
        if(i+1 < m && obstacleGrid[i+1][j] != 1){
            down = helper(i+1, j, m, n, obstacleGrid, memo);
        }
        
        int right = 0;
        if(j+1 < n && obstacleGrid[i][j+1] != 1){
            right = helper(i, j+1, m, n, obstacleGrid, memo);
        }
        
        return memo[i][j] = down + right;
    }
};