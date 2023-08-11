class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> memo(n, vector<int>(amount+1, -1));
        return helper(n-1, amount, coins, memo);
    }
    
private:
    int helper(int index, int amount, vector<int>& coins, vector<vector<int>>& memo){
        if(amount == 0){
            return 1;
        }
        if(index < 0){
            return 0;
        }
        
        if(memo[index][amount] != -1){
            return memo[index][amount];
        }

        
        if(coins[index] <= amount){
            // We can include
            return memo[index][amount] = helper(index-1, amount, coins, memo) + helper(index, amount-coins[index], coins, memo);
        }
        
        return memo[index][amount] = helper(index-1, amount, coins, memo);
    }
};