class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> memo = new HashMap<>();
        return helper(s, wordDict, memo);
    }
    
    private boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> memo){
        if(s.length() == 0){
            return true;
        }
        
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        
        boolean isPossible = false;
        
        for(String word: wordDict){
            if(s.startsWith(word)){
                isPossible = isPossible || helper(s.substring(word.length()), wordDict, memo);
            }
        }
        
        memo.put(s, isPossible);
        
        return memo.get(s);
    }
}

/*
Recursion:
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }
    
    private boolean helper(String s, List<String> wordDict){
        if(s.length() == 0){
            return true;
        }
        
        boolean isPossible = false;
        
        for(String word: wordDict){
            if(s.startsWith(word)){
                isPossible = isPossible || helper(s.substring(word.length()), wordDict);
            }
        }
        
        return isPossible;
    }
*/