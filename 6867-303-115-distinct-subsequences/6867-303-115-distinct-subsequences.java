class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][] memo = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }
        return countDistinctSubsequences(m, n, s, t, memo);
    }

    private int countDistinctSubsequences(int index1, int index2, String s, String t, int [][] memo){
        if(index2 == 0){
            return 1; // This means we were able to find string t in string 1
        }

        if(index1 == 0){
            return 0; // This means string s is exhausted but not t in that case we will return 0
        }

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }

        if(s.charAt(index1-1) == t.charAt(index2-1)){
            return memo[index1][index2] = (countDistinctSubsequences(index1-1, index2-1, s, t, memo) + countDistinctSubsequences(index1-1, index2, s, t, memo));
        }
        // Not matching chars
        return memo[index1][index2] = countDistinctSubsequences(index1-1, index2, s, t, memo);
    }
}

/*
Recursion:

public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        return countDistinctSubsequences(m, n, s, t);
    }

    private int countDistinctSubsequences(int index1, int index2, String s, String t){
        if(index2 == 0){
            return 1; // This means we were able to find string t in string 1
        }

        if(index1 == 0){
            return 0; // This means string s is exhausted but not t in that case we will return 0
        }

        if(s.charAt(index1-1) == t.charAt(index2-1)){
            return (countDistinctSubsequences(index1-1, index2-1, s, t) + countDistinctSubsequences(index1-1, index2, s, t));
        }
        // Not matching chars
        return countDistinctSubsequences(index1-1, index2, s, t);
    }
*/