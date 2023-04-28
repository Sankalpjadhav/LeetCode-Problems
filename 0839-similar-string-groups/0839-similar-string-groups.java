class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(calculateDigitDifference(strs[i], strs[j]) <= 2){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        boolean [] visited = new boolean[n];
        int numberOfSimilarGroups = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                numberOfSimilarGroups+=1;
                visited[i] = true;
                dfs(i, visited, adjList);
            }
        }
        
        return numberOfSimilarGroups;
    }
    
    private void dfs(int i, boolean [] visited, List<List<Integer>> adjList){
        
        for(int adjNode: adjList.get(i)){
            if(!visited[adjNode]){
                visited[adjNode] = true;
                dfs(adjNode, visited, adjList);
            }
        }
    }
    
    
    private int calculateDigitDifference(String str1, String str2){
        int digitDifference = 0;
        int i = 0;
        int j = 0;
        
        while(i < str1.length()){
            if(str1.charAt(i) != str2.charAt(j)){
                digitDifference++;
            }
            i++;
            j++;
        }
        
        return digitDifference;
    }
}