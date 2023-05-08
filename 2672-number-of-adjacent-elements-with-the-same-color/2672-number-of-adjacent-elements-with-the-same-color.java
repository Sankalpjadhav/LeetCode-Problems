class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int [] colors = new int[n];
        int [] answer = new int[queries.length];
        
        int numberOfPairs = 0;
        
        for(int i=0;i<queries.length;i++){
            int index = queries[i][0];
            int color = queries[i][1];
            
            if(colors[index] != 0){
                if(index-1 >= 0 && colors[index-1] == colors[index]){
                    // meaning we are trying to override color at index which is already included as pair with same color
                    numberOfPairs--;
                }
                if(index+1 < n && colors[index+1] == colors[index]){
                    numberOfPairs--;
                }
            }
            
            colors[index] = color;
            
            if(index-1 >= 0 && colors[index-1] == colors[index]){
                numberOfPairs++;
            }
            if(index+1 < n && colors[index+1] == colors[index]){
                numberOfPairs++;
            }
            
            answer[i] = numberOfPairs;
        }
        
        return answer;
    }
}