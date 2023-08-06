class Solution {
public:
    int MOD = 1e9 + 7;
    int numMusicPlaylists(int n, int goal, int k) {
        vector<vector<int>> memo(goal+1, vector<int>(goal+1,-1));
        return helper(n, goal, k, 0, 0, memo);
    }
    
private:
    int helper(int nSongs, int goal, int k, int currentLength, int numOfUniqueSongs, vector<vector<int>>&memo){
        if(currentLength == goal){
            return (numOfUniqueSongs == nSongs);
        }
        
        if(memo[currentLength][numOfUniqueSongs]!=-1){
            return memo[currentLength][numOfUniqueSongs];
        }
        
        // To pick songs from the already selected songs
        long long int option1 = (long long int)helper(nSongs, goal, k, currentLength+1, numOfUniqueSongs, memo)%MOD * max(0, numOfUniqueSongs-k)%MOD;
        
        // To pick songs from the remaining list of songs
        long long int option2 = (long long int)helper(nSongs, goal, k, currentLength+1, numOfUniqueSongs+1, memo)%MOD * max(0, nSongs-numOfUniqueSongs) % MOD;
        
        return memo[currentLength][numOfUniqueSongs] = (option1 + option2) % MOD;
    }
};