class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int [] numberOfWhites = new int[n];

        numberOfWhites[0] = blocks.charAt(0) == 'W' ? 1 : 0;
        for(int i=1;i<n;i++){
            char ch = blocks.charAt(i);
            if(ch == 'W'){
                numberOfWhites[i] = numberOfWhites[i-1] + 1;
            }
            else{
                numberOfWhites[i] = numberOfWhites[i-1];
            }
        }

        int minOperations = n;
        int index = 0;

        while(index+k <= n){
            int operations = numberOfWhites[index+k-1] - (index > 0 ? numberOfWhites[index - 1] : 0);
            minOperations = Math.min(operations, minOperations);
            index++;
        }

        return minOperations;
    }

}

/*
Brute force approach: O(N*N)

public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int index = 0;
        int minOperations = n;
        while(index+k <= n){
            String substr = blocks.substring(index, index+k);
            int operations = calculateOperations(substr);
            minOperations = Math.min(operations, minOperations);
            index++;
        }

        return minOperations;
    }

    private int calculateOperations(String substr){
        int numberOfWhiteBalls = 0;
        for(int i=0;i<substr.length();i++){
            char ch = substr.charAt(i);
            if(ch == 'W'){
                numberOfWhiteBalls++;
            }
        }

        return numberOfWhiteBalls;
    }
*/