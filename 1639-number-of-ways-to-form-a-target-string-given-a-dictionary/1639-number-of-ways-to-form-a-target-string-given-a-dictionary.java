class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int numWays(String[] words, String target) {
        int n = target.length();
        int wordLength = words[0].length();
        
        int[][] freq = new int[26][wordLength]; // freq[i][j] = frequency of j+'a' in the ith column of the matrix
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < wordLength; j++) {
                freq[words[i].charAt(j) - 'a'][j]++;
            }
        }
        
        int [][] memo = new int[n][wordLength];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(0, 0, words, target, memo, freq) % MOD;
    }
    
    private int helper(int targetIndex, int index, String [] words, String target, int [][] memo, int [][] freq){
        if(targetIndex == target.length()){
            return 1;
        }
        
        if(index == words[0].length()){
            return 0;
        }
        
        if(memo[targetIndex][index] != -1){
            return memo[targetIndex][index];
        }
        
        int notPick = helper(targetIndex, index+1, words, target, memo, freq) % MOD;
        
        long pick = 0;
        
        /*
        for(int i=0;i<words.length;i++){
            if(target.charAt(targetIndex) == words[i].charAt(index)){
                currentCharFrequency++;
            }    
        }
        */
        if(freq[target.charAt(targetIndex)-'a'][index] != 0){
            int currentCharFrequency = freq[target.charAt(targetIndex)-'a'][index];
            pick = ((currentCharFrequency % MOD) * (long)(helper(targetIndex+1, index+1, words, target, memo, freq) % MOD) ) % MOD;
        }
        return memo[targetIndex][index] = (int) (pick + notPick) % MOD;
    }
}


/*
MEMOIZATION: TLE

class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int numWays(String[] words, String target) {
        int n = target.length();
        int wordLength = words[0].length();
        
        int [][] memo = new int[n][wordLength];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(0, 0, words, target, memo) % MOD;
    }
    
    private int helper(int targetIndex, int index, String [] words, String target, int [][] memo){
        if(targetIndex == target.length()){
            return 1;
        }
        
        if(index == words[0].length()){
            return 0;
        }
        
        if(memo[targetIndex][index] != -1){
            return memo[targetIndex][index];
        }
        
        int notPick = helper(targetIndex, index+1, words, target, memo) % MOD;
        
        long pick = 0;
        int currentCharFrequency = 0;
        
        for(int i=0;i<words.length;i++){
            if(target.charAt(targetIndex) == words[i].charAt(index)){
                currentCharFrequency++;
            }    
        }
        
        pick = ((currentCharFrequency % MOD) * (long)(helper(targetIndex+1, index+1, words, target, memo) % MOD) ) % MOD;
        return memo[targetIndex][index] = (int) (pick + notPick) % MOD;
    }
}



RECURSION: Obviously TLE

class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int numWays(String[] words, String target) {
        return helper(0, 0, words, target) % MOD;
    }
    
    private int helper(int targetIndex, int index, String [] words, String target){
        if(targetIndex == target.length()){
            return 1;
        }
        
        if(index == words[0].length()){
            return 0;
        }
        
        int notPick = helper(targetIndex, index+1, words, target) % MOD;
        
        long pick = 0;
        int currentCharFrequency = 0;
        
        for(int i=0;i<words.length;i++){
            if(target.charAt(targetIndex) == words[i].charAt(index)){
                currentCharFrequency++;
            }    
        }
        
        pick = ((currentCharFrequency % MOD) * (long)(helper(targetIndex+1, index+1, words, target) % MOD) ) % MOD;
        return (int) (pick + notPick) % MOD;
    }
}
*/