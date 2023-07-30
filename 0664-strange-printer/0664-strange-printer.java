class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int [][] memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return strangePrinter(0, n - 1, s, memo);
    }

    private int strangePrinter(int i, int j, String s, int [][] memo) {
        if (i == j) {
            return 1;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int minTurns = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            minTurns = Math.min(
                minTurns,
                strangePrinter(i, k, s, memo) + strangePrinter(k + 1, j, s, memo)
            );
        }

        return memo[i][j] = s.charAt(i) == s.charAt(j) ? minTurns - 1 : minTurns;
    }
}

/*
- For each of the string 's'
        - If 's' has a length of 1
            - Then we can use 1 turn to generate the string
        - If 's' has a length of greater than 1
            - We can partition the string into substrings 'x' and 'y'
                - Then we can find the turns of both of the substrings
                - Then the number of turns of 's' will be 'turns(x) + turns(y)'
            - Since, we want the smallest number of turns
                - We will want to pick the index 'k' that will give us
                  the partition that will give us the smallest number of turns
            - A side case we have to handle is when the first character is
              equal to the last character
                - Then we have to decrement the number of turns by 1
                - Examples: "aa"
                    - We do not want 1 + 1 = 2, because the printer can
                      generate a sequence of the same characters
                    - We will want to decrement it to '2 - 1 = 1'
    - We can keep track of our current left 'i' and right 'j' boundaries
      of the input string and find the minimum number of turns
*/