class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int numberOfPeople = quiet.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<numberOfPeople;i++){
            adjList.add(i, new ArrayList<>());
        }
        
        for(int [] rich: richer){
            adjList.get(rich[1]).add(rich[0]);
        }
        
        int [] answer = new int[numberOfPeople];
        Arrays.fill(answer, -1);
        
        for(int i=0;i<numberOfPeople;i++){
            dfs(i, adjList, quiet, answer);
        }
        
        return answer;
    }
    
    private int dfs(int node, List<List<Integer>> adjList, int [] quiet, int [] answer){
        if(answer[node]!=-1)
            return answer[node];
        

        answer[node] = node;
        for(int adjNode: adjList.get(node))
        {
            if(quiet[dfs(adjNode, adjList, quiet, answer)] < quiet[answer[node]])
            {
                answer[node]=answer[adjNode];
            }
        }
        
        return answer[node];
        
    }
}


/*

GIVES TLE: 71 / 86 test cases passed.

public int[] loudAndRich(int[][] richer, int[] quiet) {
        int numberOfPeople = quiet.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<numberOfPeople;i++){
            adjList.add(i, new ArrayList<>());
        }
        
        for(int [] rich: richer){
            adjList.get(rich[1]).add(rich[0]);
        }
        
        int [] answer = new int[numberOfPeople];
        
        for(int i=0;i<numberOfPeople;i++){
            int [] leastQuiet = {i};
            dfs(i, adjList, quiet, leastQuiet);
            answer[i] = leastQuiet[0];
        }
        
        return answer;
    }
    
    private void dfs(int node, List<List<Integer>> adjList, int [] quiet, int [] leastQuiet){
        if(quiet[leastQuiet[0]] > quiet[node]){
            leastQuiet[0] = node;
        }
        
        for(int adjNode: adjList.get(node)){
            dfs(adjNode, adjList, quiet, leastQuiet);
        }
    }

*/